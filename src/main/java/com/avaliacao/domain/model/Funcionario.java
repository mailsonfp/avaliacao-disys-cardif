package com.avaliacao.domain.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Integer id;
	
	@Column(name = "funcionario_codigo")
	private String codigo;
	
	@Column(name = "funcionario_name")
	private String nome;
	
	@Column(name = "funcionario_age")
	private Integer idade;
	
	@Column(name = "funcionario_birthday")
	private Date dataNascimento;
	
	@Column(name = "funcionario_document")
	private String documento;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@ManyToMany
	@JoinTable(name = "funcionario_departamento", joinColumns = @JoinColumn(name =  "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "departamento_id") )
	private Set<Departamento> departamentos = new HashSet<>();
	
	public Funcionario() {
		
	}

	public Funcionario(String codigo, String nome, Integer idade, Date dataNascimento, String documento, Cargo cargo) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.documento = documento;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public void setIdade(Integer age) {
		this.idade = age;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public boolean adicionaDepartamento(Departamento departamento) {
		return getDepartamentos().add(departamento);
	}
	
	public boolean removerDepartamento(Departamento departamento) {
		return getDepartamentos().remove(departamento);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
