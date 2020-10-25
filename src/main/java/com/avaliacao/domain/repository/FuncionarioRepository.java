package com.avaliacao.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avaliacao.domain.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	public Optional<Funcionario> findByCodigo(String codigo);
	
	@Query("from Funcionario fun inner join fun.departamentos as departamento where departamento.id = :idDepartamento")
	public List<Funcionario> listarPorDepartamento(Integer idDepartamento);
}
