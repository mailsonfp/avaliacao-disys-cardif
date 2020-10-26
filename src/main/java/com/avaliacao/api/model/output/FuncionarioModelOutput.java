package com.avaliacao.api.model.output;

import java.sql.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FuncionarioModelOutput {
	
	@ApiModelProperty(value = "Código do Funcionário", example = "FUN01")
	private String codigo;
	
	@ApiModelProperty(value = "Código do Funcionário", example = "FUN01")
	private String nome;
	
	@ApiModelProperty(value = "Idade do Funcionário", example = "32")
	private Integer idade;
	
	@ApiModelProperty(value = "Data de Nascimento do funcionário", example = "21/11/1988")
	private Date dataNascimento;
	
	@ApiModelProperty(value = "Documento do funcionário", example = "44444444-5")
	private String documento;
	
	@ApiModelProperty(value = "Cargo do Funcionário")
	private CargoModelOutput cargo;
	
	@ApiModelProperty(value = "Departamentos aos quais o Funcionário está vinculado")
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
