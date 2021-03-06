package com.avaliacao.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="departamento_id")
	private Integer id;
	
	@Column(name="departamento_codigo")
	private String codigo;
	
	@Column(name = "departamento_name")
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "departamento_id_cargo_chefe")
	private Cargo chefeDepartamento;
	
	public Departamento() {		
	}
	
	public Departamento(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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

	public Cargo getChefeDepartamento() {
		return chefeDepartamento;
	}

	public void setChefeDepartamento(Cargo chefeDepartamento) {
		this.chefeDepartamento = chefeDepartamento;
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
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
