package com.avaliacao.api.model.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.api.model.input.FuncionarioModelInput;
import com.avaliacao.api.model.output.FuncionarioModelOutput;
import com.avaliacao.domain.model.Funcionario;

@Component
public class FuncionarioConverter {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public FuncionarioModelOutput toModel(Funcionario funcionario) {
		return modelMapper.map(funcionario, FuncionarioModelOutput.class);
	}
	
	public List<FuncionarioModelOutput> toCollectionModel(List<Funcionario> funcionarios){
		return funcionarios.stream()
				.map(funcionario -> toModel(funcionario))
				.collect(Collectors.toList());
	}
	
	public Funcionario toDomainObject(FuncionarioModelInput funcionarioInput) {
		 return modelMapper.map(funcionarioInput, Funcionario.class);
	}
	
	public void copyToDomainObject(FuncionarioModelInput funcionarioInput, Funcionario funcionario) {
		modelMapper.map(funcionarioInput, funcionario);
	}
	
}
