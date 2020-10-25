package com.avaliacao.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.avaliacao.api.model.input.FuncionarioModelInput;
import com.avaliacao.domain.model.Funcionario;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(FuncionarioModelInput.class, Funcionario.class)
	    .addMappings(mapper -> mapper.skip(Funcionario::setCodigo));
		
		return modelMapper;
	}
}
