package com.avaliacao.core.inicialization;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.avaliacao.domain.model.Cargo;
import com.avaliacao.domain.model.Departamento;
import com.avaliacao.domain.model.Funcionario;
import com.avaliacao.domain.service.CargoService;
import com.avaliacao.domain.service.DepartamentoService;
import com.avaliacao.domain.service.FuncionarioService;

@Configuration
public class Inicialization implements CommandLineRunner {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public void run(String... args) throws Exception {
		Departamento dep1 = new Departamento("DEP01","Departamento 01");
		Departamento dep2 = new Departamento("DEP02","Departamento 02");
		Departamento dep3 = new Departamento("DEP03","Departamento 03");
		Departamento dep4 = new Departamento("DEP04","Departamento 04");		
		departamentoService.salvarTodos(Arrays.asList(dep1,dep2,dep3,dep4));
		
		Cargo cargo1 = new Cargo("CRG01","Cargo 01");
		Cargo cargo2 = new Cargo("CRG02","Cargo 02");
		Cargo cargo3 = new Cargo("CRG03","Cargo 03");
		Cargo cargo4 = new Cargo("CRG04","Cargo 04");
		cargoService.salvarTodos(Arrays.asList(cargo1,cargo2,cargo3,cargo4));
		
		Funcionario fun1 = new Funcionario("FUN01", "Funcionario1", 32, new Date(), "11111111", cargo1);
		fun1.getDepartamentos().add(dep1);
		fun1.getDepartamentos().add(dep2);
		Funcionario fun2 = new Funcionario("FUN02","Funcionario2", 35, new Date(), "22222222", cargo1);
		fun2.getDepartamentos().add(dep2);
		fun2.getDepartamentos().add(dep3);
		Funcionario fun3 = new Funcionario("FUN03","Funcionario3", 40, new Date(), "33333333", cargo2);
		fun3.getDepartamentos().add(dep3);
		Funcionario fun4 = new Funcionario("FUN04","Funcionario4", 45, new Date(), "44444444", cargo3);
		fun4.getDepartamentos().add(dep1);
		fun4.getDepartamentos().add(dep3);
		funcionarioService.salvarTodos(Arrays.asList(fun1,fun2,fun3,fun4));
	}

}
