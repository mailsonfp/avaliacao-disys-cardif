package com.avaliacao.api.openapi.controller;

import java.util.List;

import com.avaliacao.api.exceptionhandler.Problema;
import com.avaliacao.api.model.input.CargoModelInput;
import com.avaliacao.api.model.output.CargoModelOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cargos")
public interface CargoControllerOpenApi {
	
	@ApiOperation("Lista todos os cargos")
	public List<CargoModelOutput> listar();
	
	@ApiOperation("Busca um Cargo por código")
	@ApiResponses({		
		@ApiResponse(code=404, message = "Não foi possível localizar um Cargo com o código informado", response = Problema.class)
	})
	public CargoModelOutput buscar(@ApiParam(value = "Código de um cargo", example = "CRG01", required = true) String codigoCargo);
	
	@ApiOperation("Cadastra um novo Cargo")
	@ApiResponses({
		@ApiResponse(code=201, message = "Cargo cadastrado com sucesso")
	})
	public CargoModelOutput adicionar(@ApiParam(name="corpo", value = "representação de um novo Departamento", required = true) CargoModelInput cargoInput);

	@ApiOperation("Atualiza um Cargo por código")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento excluído com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public CargoModelOutput atualizar(
			@ApiParam(value = "Código de um cargo", example = "CRG01", required = true) String codigoCargo,
			@ApiParam(name="corpo", value = "representação de um novo Departamento", required = true) CargoModelInput cargoInput);
	
	@ApiOperation("Exclui um Cargo por código")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento excluído com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado", response = Problema.class),
		@ApiResponse(code=409, message = "Não é possível excluir o Cargo informado porque ele está relacionado a uma ou mais entidades", response = Problema.class)
	})
	public void excluir(@ApiParam(value = "Código de um cargo", example = "CRG01", required = true) String codigocargo);
}
