package com.avaliacao.api.model.output;

import io.swagger.annotations.ApiModelProperty;

public class DepartamentoModelOutput {
	
	@ApiModelProperty(value = "Código do Departamento", example = "DEP01")
	private String codigo;
	
	@ApiModelProperty(value = "Nome do Departamento", example = "Departamento 01")
	private String nome;
	
	@ApiModelProperty(value = "Código do Departamento", example = "Chefe de Departamento")
	private CargoModelOutput chefeDepartamento;
	
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

	public CargoModelOutput getChefeDepartamento() {
		return chefeDepartamento;
	}

	public void setChefeDepartamento(CargoModelOutput chefeDepartamento) {
		this.chefeDepartamento = chefeDepartamento;
	}
		
}
