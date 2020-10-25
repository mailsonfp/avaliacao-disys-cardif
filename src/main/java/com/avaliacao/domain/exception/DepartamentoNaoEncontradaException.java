package com.avaliacao.domain.exception;

public class DepartamentoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public DepartamentoNaoEncontradaException(String codigoDepartamento) {
		super(String.format("Não foi possível localizar um Departamento com o código: %s", codigoDepartamento));
	}


}
