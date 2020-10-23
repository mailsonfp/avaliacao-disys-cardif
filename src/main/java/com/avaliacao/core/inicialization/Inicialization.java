package com.avaliacao.core.inicialization;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.service.DepartamentoService;

@Configuration
public class Inicialization implements CommandLineRunner {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public void run(String... args) throws Exception {
		Departamento dep1 = new Departamento("DEP01","Desenvolvimento");
		Departamento dep2 = new Departamento("DEP02","DevOps");
		Departamento dep3 = new Departamento("DEP03","Infraestrurtura");
		Departamento dep4 = new Departamento("DEP04","Arquitetura");
		
		departamentoService.salvarTodos(Arrays.asList(dep1,dep2,dep3,dep4));
	}

}
