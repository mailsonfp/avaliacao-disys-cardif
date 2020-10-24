package com.avaliacao.domain.exception;

public class CargoNaoEncontradaException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;
	
	public CargoNaoEncontradaException(String codigoCargo) {
		super(String.format("Não foi possível localizar um Cargo com o código: %s", codigoCargo));
	}	

}
