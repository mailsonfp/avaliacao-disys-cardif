package com.avaliacao.api.model.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avaliacao.api.model.input.CargoModelInput;
import com.avaliacao.api.model.output.CargoModelOutput;
import com.avaliacao.domain.model.Cargo;

@Component
public class CargoConverter {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public CargoModelOutput toModel(Cargo cargo) {
		return modelMapper.map(cargo, CargoModelOutput.class);
	}
	
	public List<CargoModelOutput> toCollectionModel(List<Cargo> cargos){
		return cargos.stream()
				.map(cargo -> toModel(cargo))
				.collect(Collectors.toList());
	}
	
	public Cargo toDomainObject(CargoModelInput cargoInput) {
		 return modelMapper.map(cargoInput, Cargo.class);
	}
	
	public void copyToDomainObject(CargoModelInput cargoInput, Cargo cargo) {
		cargo.setNome(cargoInput.getNome());
	}
	
}
