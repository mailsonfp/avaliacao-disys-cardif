package com.avaliacao.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.domain.exception.DepartamentoNaoEncontradaException;
import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> listar(){
		return departamentoRepository.findAll();
	}
	
	public Optional<Departamento> buscarPorId(Integer idDepartamento) {
		return departamentoRepository.findById(idDepartamento);
	}
	
	public Departamento buscarPorCodigo(String codigoDepartamento) {
		return departamentoRepository.findByCodigo(codigoDepartamento).orElseThrow(() -> new DepartamentoNaoEncontradaException(codigoDepartamento));
	}
	
	@Transactional
	public Departamento salvar(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	@Transactional
	public void excluir(String codigoDepartamento) {
		Departamento dep = buscarPorCodigo(codigoDepartamento);
		departamentoRepository.deleteById(dep.getId());
	}
	
	@Transactional
	public void salvarTodos(List<Departamento> listaDepartamentos) {
		departamentoRepository.saveAll(listaDepartamentos);
	}	
}
