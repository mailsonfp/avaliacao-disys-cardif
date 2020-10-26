package com.avaliacao.api.openapi.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;

import com.avaliacao.api.exceptionhandler.Problema;
import com.avaliacao.domain.model.Departamento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Funcionários")
public interface FuncionarioDepartamentoControllerOpenApi {
	
	@ApiOperation("Lista todos os Departamentos do Funcionário informado")
	public Set<Departamento> listar(@PathVariable String codigoFuncionario);
	
	@ApiOperation("Vincula o Funcionário informado ao Departamento informado")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento vinculado com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado/Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public void vincularDepartamento(
			@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario,
			@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento);
	
	@ApiOperation("Desvincula o Departamento informado do Funcionário informado")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento vinculado com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado/Não foi possível localizar um Departamento com o código informado", response = Problema.class)
	})
	public void desvincularDepartamento(
			@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario,
			@ApiParam(value = "Código de um departamento", example = "DEP01", required = true) String codigoDepartamento);
}
