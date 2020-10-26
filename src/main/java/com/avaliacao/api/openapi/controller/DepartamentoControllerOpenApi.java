package com.avaliacao.api.openapi.controller;

import java.util.List;

import com.avaliacao.api.exceptionhandler.Problema;
import com.avaliacao.api.model.input.DepartamentoModelInput;
import com.avaliacao.api.model.output.DepartamentoModelOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Departamentos")
public interface DepartamentoControllerOpenApi {
	
	@ApiOperation("Lista todos os departamentos")
	public List<DepartamentoModelOutput> listar();
	
	@ApiOperation("Busca um Departamento por código")
	@ApiResponses({		
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public DepartamentoModelOutput buscar(@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento);
	
	@ApiOperation("Cadastra um novo Departamento")
	@ApiResponses({
		@ApiResponse(code=201, message = "Departamento cadastrado com sucesso")
	})
	public DepartamentoModelOutput adicionar(@ApiParam(name="corpo", value = "representação de um novo Departamento", required = true) DepartamentoModelInput departamentoInput);
	
	@ApiOperation("Atualiza um departamento por código")
	@ApiResponses({		
		@ApiResponse(code=200, message = "Departamento atualizado com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public DepartamentoModelOutput atualizar(
			@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento,
			@ApiParam(name="corpo", value = "representação de um novo Departamento", required = true) DepartamentoModelInput departamentoInput);
			
	
	@ApiOperation("Exclui um Departamento por código")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento excluído com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public void excluir(@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento);
	
	@ApiOperation("Define o cargo que será chefe do departamento")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Chefe de departamento definido com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com o código informado/Não foi possível localizar um Cargo com o código informado",
		response = Problema.class),
	})
	public void defineChefeDepartamento(
		@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento,
		@ApiParam(value = "Código de um cargo", example = "CRG01", required = true) String codigoCargo);
}
