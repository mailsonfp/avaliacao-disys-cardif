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

import com.avaliacao.api.model.convert.CargoConverter;
import com.avaliacao.api.model.input.CargoModelInput;
import com.avaliacao.api.model.output.CargoModelOutput;
import com.avaliacao.api.openapi.controller.CargoControllerOpenApi;
import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.service.CargoService;

@RestController
@RequestMapping(path = "/cargos")
public class CargoController implements CargoControllerOpenApi {
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private CargoConverter cargoConverter;
	
	@Override
	@GetMapping
	public List<CargoModelOutput> listar(){
		return cargoConverter.toCollectionModel(cargoService.listar());
	}
	
	@Override
	@GetMapping("{codigoCargo}")
	public CargoModelOutput buscar(@PathVariable String codigoCargo) {
		return cargoConverter.toModel(cargoService.buscarPorCodigo(codigoCargo));
	}
	
	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CargoModelOutput adicionar(@Valid @RequestBody CargoModelInput cargoInput) {
		Cargo cargo = cargoConverter.toDomainObject(cargoInput);
				
		return cargoConverter.toModel(cargoService.salvar(cargo));
	}
	
	@Override
	@PutMapping("{codigoCargo}")
	@ResponseStatus(HttpStatus.CREATED)
	public CargoModelOutput atualizar(@PathVariable String codigoCargo, @Valid @RequestBody CargoModelInput cargoInput) {
		Cargo cargo = cargoService.buscarPorCodigo(codigoCargo);
		cargoConverter.copyToDomainObject(cargoInput, cargo);
				
		return cargoConverter.toModel(cargoService.salvar(cargo));
	}
	
	@Override
	@DeleteMapping("{codigocargo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable String codigocargo){
		cargoService.excluir(codigocargo);
	}
	
}
