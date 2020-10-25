package com.avaliacao.api.model.input;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class FuncionarioModelInput {
	
	@NotBlank
	private String codigo;
	
	@NotBlank
	private String nome;
	
	private Integer idade;
	
	private Date dataNascimento;
	
	private String documento;
	
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

}
