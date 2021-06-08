package com.avaliacao.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.api.model.convert.FuncionarioConverter;
import com.avaliacao.api.model.input.FuncionarioModelInput;
import com.avaliacao.api.model.output.FuncionarioModelOutput;
import com.avaliacao.api.openapi.controller.FuncionarioControllerOpenApi;
import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.model.Funcionario;
import com.avaliacao.domain.service.CargoService;
import com.avaliacao.domain.service.FuncionarioService;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController implements FuncionarioControllerOpenApi {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioConverter funcionarioConverter;
	
	@Autowired
	private CargoService cargoService;
	
	@Override
	@GetMapping
	public List<FuncionarioModelOutput> listar(){
		return funcionarioConverter.toCollectionModel(funcionarioService.listar());
	}
	
	@Override
	@GetMapping("{codigoFuncionario}")
	public FuncionarioModelOutput buscarPorCodigo(@PathVariable String codigoFuncionario) {
		return funcionarioConverter.toModel(funcionarioService.buscarPorCodigo(codigoFuncionario));
	}
	
	@Override
	@GetMapping("/por-departamento/{codigoDepartamento}")
	public List<FuncionarioModelOutput> listarPorDepartamento(@PathVariable String codigoDepartamento) {
		return funcionarioConverter.toCollectionModel(funcionarioService.listarPorDepartamentos(codigoDepartamento));
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncionarioModelOutput adicionar(@Valid @RequestBody FuncionarioModelInput funcionarioInput) {				
		Funcionario fun = funcionarioConverter.toDomainObject(funcionarioInput);
		fun.setCodigo(funcionarioInput.getCodigo());
		
		return funcionarioConverter.toModel(funcionarioService.salvar(fun));			
	}
	
	@Override
	@PutMapping("{codigoFuncionario}")
	@ResponseStatus(HttpStatus.OK)
	public FuncionarioModelOutput atualizar(@PathVariable String codigoFuncionario, @Valid @RequestBody FuncionarioModelInput funcionarioInput) {
		Funcionario fun = funcionarioService.buscarPorCodigo(codigoFuncionario);
	
		funcionarioConverter.copyToDomainObject(funcionarioInput, fun);

		return funcionarioConverter.toModel(funcionarioService.salvar(fun));
	}
	
	@Override
	@PutMapping("/{codigoFuncionario}/cargo/{codigoCargo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public FuncionarioModelOutput atualizarCargo(@PathVariable String codigoFuncionario, @PathVariable String codigoCargo) {		
		Funcionario fun = funcionarioService.buscarPorCodigo(codigoFuncionario);
		
		String codigoCargoAntigo = fun.getCargo() == null ? "" : fun.getCargo().getCodigo();
		Integer idCargo = retornaIdCargo(codigoCargo, codigoCargoAntigo);

		return funcionarioConverter.toModel(funcionarioService.salvar(fun,idCargo));
	}

	private Integer retornaIdCargo(String codigoNovoCargo, String codigoCargoAntigo) {
		if(!codigoNovoCargo.equals(codigoCargoAntigo)) {
			Cargo cargo = cargoService.buscarPorCodigo(codigoNovoCargo);
			return cargo.getId();
		}
		return 0;
	}	
	
	@Override
	@DeleteMapping("{codigoFuncionario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable String codigoFuncionario){
		funcionarioService.excluir(codigoFuncionario);
	}
}
