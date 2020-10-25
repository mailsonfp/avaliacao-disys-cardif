package com.avaliacao.api.model.output;

public class DepartamentoModelOutput {
	
	private String codigo;
	
	private String nome;
	
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
