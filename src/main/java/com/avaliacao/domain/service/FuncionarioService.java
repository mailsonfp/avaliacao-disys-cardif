package com.avaliacao.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avaliacao.domain.exception.FuncionarioNaoEncontradaException;
import com.avaliacao.domain.exception.NegocioException;
import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.model.Funcionario;
import com.avaliacao.domain.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;	
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	public List<Funcionario> listar(){
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> buscarPorId(Integer idFuncionario) {
		return funcionarioRepository.findById(idFuncionario);
	}
	
	public Funcionario buscarPorCodigo(String codigoFuncionario) {
		return funcionarioRepository.findByCodigo(codigoFuncionario).orElseThrow(() -> new FuncionarioNaoEncontradaException(codigoFuncionario));
	}
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		Optional<Funcionario> funExistente = funcionarioRepository.findByCodigo(funcionario.getCodigo());
		if(funExistente.isPresent()) {
			throw new NegocioException(String.format("O código '%s' já foi cadastrado para o Funcionário '%s'.",funExistente.get().getCodigo(), funExistente.get().getNome()));
		}
								
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario, Integer idCargo) {		
		Optional<Cargo> cargo = cargoService.buscarPorId(idCargo);
		funcionario.setCargo(cargo.get());
		return funcionarioRepository.save(funcionario);
	}
	
	@Transactional
	public void excluir(String codigoFuncionario) {
		Funcionario dep = buscarPorCodigo(codigoFuncionario);
		funcionarioRepository.deleteById(dep.getId());
	}
	
	@Transactional
	public void salvarTodos(List<Funcionario> listaFuncionarios) {
		funcionarioRepository.saveAll(listaFuncionarios);
	}
	
	@Transactional
	public void vincularDepartamento(String codigoFuncionario, String codigoDepartamento) {
		Funcionario fun = buscarPorCodigo(codigoFuncionario);
		Departamento dep = departamentoService.buscarPorCodigo(codigoDepartamento);
		
		fun.adicionaDepartamento(dep);
	}
	
	@Transactional
	public void desvincularDepartamento(String codigoFuncionario, String codigoDepartamento) {
		Funcionario fun = buscarPorCodigo(codigoFuncionario);
		Departamento dep = departamentoService.buscarPorCodigo(codigoDepartamento);
		
		fun.removerDepartamento(dep);
	}
	
	public List<Funcionario> listarPorDepartamentos(String codigoDepartamento){
		Departamento dep = departamentoService.buscarPorCodigo(codigoDepartamento);
		return funcionarioRepository.listarPorDepartamento(dep.getId());
	}
}
