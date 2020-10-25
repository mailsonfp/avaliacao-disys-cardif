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

import com.avaliacao.api.model.convert.DepartamentoConverter;
import com.avaliacao.api.model.input.DepartamentoModelInput;
import com.avaliacao.api.model.output.DepartamentoModelOutput;
import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private DepartamentoConverter departamentoConverter;
	
	@GetMapping
	public List<DepartamentoModelOutput> listar(){
		return departamentoConverter.toCollectionModel(departamentoService.listar());
	}
	
	@GetMapping("{codigoDepartamento}")
	public DepartamentoModelOutput buscar(@PathVariable String codigoDepartamento) {
		return departamentoConverter.toModel(departamentoService.buscarPorCodigo(codigoDepartamento));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DepartamentoModelOutput adicionar(@Valid @RequestBody DepartamentoModelInput departamentoInput) {
		Departamento dep = departamentoConverter.toDomainObject(departamentoInput);
				
		return departamentoConverter.toModel(departamentoService.salvar(dep));
	}
	
	@PutMapping("{codigoDepartamento}")
	@ResponseStatus(HttpStatus.CREATED)
	public DepartamentoModelOutput atualizar(@PathVariable String codigoDepartamento, @Valid @RequestBody DepartamentoModelInput departamentoInput) {
		Departamento dep = departamentoService.buscarPorCodigo(codigoDepartamento);
		departamentoConverter.copyToDomainObject(departamentoInput, dep);
				
		return departamentoConverter.toModel(departamentoService.salvar(dep));
	}
	
	@DeleteMapping("{codigoDepartamento}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable String codigoDepartamento){
		departamentoService.excluir(codigoDepartamento);
	}
	
	@PutMapping("/{codigoDepartamento}/define-chefe/{codigoCargo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void defineChefeDepartamento(@PathVariable String codigoDepartamento, @PathVariable String codigoCargo) {				
		departamentoService.definirChefeDepartamento(codigoDepartamento, codigoCargo);
	}
	
}
