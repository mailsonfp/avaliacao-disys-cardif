package com.avaliacao.api.model.input;

import javax.validation.constraints.NotBlank;

public class CargoModelInput {
	
	@NotBlank
	private String codigo;
	
	@NotBlank
	private String nome;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
