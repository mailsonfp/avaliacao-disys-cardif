package com.avaliacao.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class CargoModelInput {
	
	@ApiModelProperty(example="CRG01", required = true)
	@NotBlank
	@Size(min = 3, max = 10)
	private String codigo;
	
	@ApiModelProperty(example="Cargo 01", required = true)
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
