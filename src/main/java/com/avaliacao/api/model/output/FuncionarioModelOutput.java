package com.avaliacao.api.model.output;

import java.sql.Date;
import java.util.List;

public class FuncionarioModelOutput {
	
	private String codigo;
	
	private String nome;
	
	private Integer idade;
	
	private Date dataNascimento;
	
	private String documento;
	
	private CargoModelOutput cargo;
	
	private List<DepartamentoModelOutput> departamentos;
	
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public CargoModelOutput getCargo() {
		return cargo;
	}

	public void setCargo(CargoModelOutput cargo) {
		this.cargo = cargo;
	}

	public List<DepartamentoModelOutput> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<DepartamentoModelOutput> departamentos) {
		this.departamentos = departamentos;
	}	
		
}
