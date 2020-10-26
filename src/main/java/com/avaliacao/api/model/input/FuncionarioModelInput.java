package com.avaliacao.api.model.input;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

public class FuncionarioModelInput {
	
	@ApiModelProperty(example = "FUN01", required = true)
	@NotBlank
	private String codigo;
	
	@ApiModelProperty(example = "Funcionário 01", required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(value = "Idade do Funcionário", example = "32")
	private Integer idade;
	
	@ApiModelProperty(value = "Data de Nascimento do funcionário", example = "21/11/1988")
	private Date dataNascimento;
	
	@ApiModelProperty(value = "Documento do funcionário", example = "44444444-5")
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
