package com.avaliacao.api.openapi.controller;

import java.util.List;

import com.avaliacao.api.exceptionhandler.Problema;
import com.avaliacao.api.model.input.FuncionarioModelInput;
import com.avaliacao.api.model.output.FuncionarioModelOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Funcionários")
public interface FuncionarioControllerOpenApi {
	
	@ApiOperation("Lista todos os Funcionários")
	public List<FuncionarioModelOutput> listar();
	
	@ApiOperation("Busca um Funcionário por código")
	@ApiResponses({		
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado", response = Problema.class)
	})
	public FuncionarioModelOutput buscarPorCodigo(@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario);
	
	@ApiOperation("Lista todos os funcionários de um departamento")
	@ApiResponses({		
		@ApiResponse(code=404, message = "Não foi possível localizar um Departamento com código informado", response = Problema.class)
	})
	public List<FuncionarioModelOutput> listarPorDepartamento(@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoDepartamento);
	
	@ApiOperation("Cadastra um novo Funcionário - apenas os dados cadastrais")
	@ApiResponses({
		@ApiResponse(code=201, message = "Funcionário cadastrado com sucesso")
	})
	public FuncionarioModelOutput adicionar(@ApiParam(name="corpo", value = "representação de um novo Funcionário com os dados cadastrais", required = true) FuncionarioModelInput funcionarioInput);
	
	@ApiOperation("Atualiza os dados cadastrais de um funcionário por código")
	@ApiResponses({		
		@ApiResponse(code=200, message = "Funcionário atualizado com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado", response = Problema.class)
	})
	public FuncionarioModelOutput atualizar(
			@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario,
			@ApiParam(name="corpo", value = "representação de um novo Funcionário com os dados cadastrais", required = true) FuncionarioModelInput funcionarioInput);
	
	@ApiOperation("Atualiza o cargo de um Funcionário")
	@ApiResponses({		
		@ApiResponse(code=200, message = "Cargo atualizado com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado", response = Problema.class)
	})
	public FuncionarioModelOutput atualizarCargo(
			@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario,
			@ApiParam(value = "Código de um Cargo", example = "CRG01", required = true) String codigoCargo);

	@ApiOperation("Exclui um Funcioário por código")
	@ApiResponses({		
		@ApiResponse(code=204, message = "Departamento excluído com sucesso", response = Problema.class),
		@ApiResponse(code=404, message = "Não foi possível localizar um Funcionário com o código informado", response = Problema.class)
	})
	public void excluir(@ApiParam(value = "Código de um Funcionário", example = "FUN01", required = true) String codigoFuncionario);
}
