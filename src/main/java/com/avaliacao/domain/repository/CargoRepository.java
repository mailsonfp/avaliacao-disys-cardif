package com.avaliacao.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacao.domain.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
	
	public Optional<Cargo> findByCodigo(String codigoCargo);

}
