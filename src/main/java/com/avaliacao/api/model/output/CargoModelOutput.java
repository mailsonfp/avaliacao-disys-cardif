package com.avaliacao.api.model.output;

import io.swagger.annotations.ApiModelProperty;

public class CargoModelOutput {
	
	@ApiModelProperty(value = "Código do Cargo", example = "CRG01")
	private String codigo;
	
	@ApiModelProperty(value = "Nome do Cargo", example = "Cargo 01")
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
