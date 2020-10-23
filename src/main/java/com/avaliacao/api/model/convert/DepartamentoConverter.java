package com.avaliacao.api.model.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.api.model.input.DepartamentoModelInput;
import com.avaliacao.api.model.output.DepartamentoModelOutput;
import com.avaliacao.domain.model.Departamento;

@Component
public class DepartamentoConverter {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public DepartamentoModelOutput toModel(Departamento departamento) {
		return modelMapper.map(departamento, DepartamentoModelOutput.class);
	}
	
	public List<DepartamentoModelOutput> toCollectionModel(List<Departamento> departamentos){
		return departamentos.stream()
				.map(departamento -> toModel(departamento))
				.collect(Collectors.toList());
	}
	
	public Departamento toDomainObject(DepartamentoModelInput departamentoInput) {
		 return modelMapper.map(departamentoInput, Departamento.class);
	 }
}
