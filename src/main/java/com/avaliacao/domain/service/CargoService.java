package com.avaliacao.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.domain.exception.CargoNaoEncontradaException;
import com.avaliacao.domain.exception.EntidadeEmUsoException;
import com.avaliacao.domain.exception.NegocioException;
import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public List<Cargo> listar(){
		return cargoRepository.findAll();
	}
	
	public Optional<Cargo> buscarPorId(Integer idCargo) {
		return cargoRepository.findById(idCargo);
	}
	
	public Cargo buscarPorCodigo(String codigoCargo) {
		return cargoRepository.findByCodigo(codigoCargo).orElseThrow(() -> new CargoNaoEncontradaException(codigoCargo));
	}
	
	@Transactional
	public Cargo salvar(Cargo cargo) {
		Optional<Cargo> cargoExistente = cargoRepository.findByCodigo(cargo.getCodigo());
		if(cargoExistente.isPresent()) {
			throw new NegocioException(String.format("O código '%s' já foi cadastrado para o Departamento '%s'.",cargoExistente.get().getCodigo(), cargoExistente.get().getNome()));
		}
		return cargoRepository.save(cargo);
	}
	
	@Transactional
	public void excluir(String codigoCargo) {
		Cargo cargo = buscarPorCodigo(codigoCargo);

		try {
			cargoRepository.deleteById(cargo.getId());
			cargoRepository.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Não é possível excluir o Cargo %s porque ele está relacionado a um ou mais funcionários", codigoCargo));
		}
	}
	
	@Transactional
	public void salvarTodos(List<Cargo> listaCargos) {
		cargoRepository.saveAll(listaCargos);
	}
}
