package com.avaliacao.domain.exception;

public class FuncionarioNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public FuncionarioNaoEncontradaException(String codigoFuncionario) {
		super(String.format("Não foi possível localizar um Funcionário com o código: %s", codigoFuncionario));
	}


}
