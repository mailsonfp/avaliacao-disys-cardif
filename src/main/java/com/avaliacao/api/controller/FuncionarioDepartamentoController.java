package com.avaliacao.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.model.Funcionario;
import com.avaliacao.domain.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios/{codigoFuncionario}/departamentos")
public class FuncionarioDepartamentoController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public Set<Departamento> listar(@PathVariable String codigoFuncionario){
		Funcionario funcionario = funcionarioService.buscarPorCodigo(codigoFuncionario);
		
		return funcionario.getDepartamentos();
	}
	
	@PutMapping("/{codigoDepartamento}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void vincularDepartamento(@PathVariable String codigoFuncionario, @PathVariable String codigoDepartamento) {
		funcionarioService.vincularDepartamento(codigoFuncionario,codigoDepartamento);
	}
	
	@DeleteMapping("/{codigoDepartamento}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void desvincularDepartamento(@PathVariable String codigoFuncionario, @PathVariable String codigoDepartamento) {
		funcionarioService.desvincularDepartamento(codigoFuncionario,codigoDepartamento);
	}
}
