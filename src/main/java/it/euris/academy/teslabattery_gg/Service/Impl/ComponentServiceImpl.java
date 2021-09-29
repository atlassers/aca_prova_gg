package it.euris.academy.teslabattery_gg.Service.Impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.teslabattery_gg.Repository.ComponentRepository;
import it.euris.academy.teslabattery_gg.Service.ComponentService;
import it.euris.academy.teslabattery_gg.data.Dto.ComponentDto;
import it.euris.academy.teslabattery_gg.data.Model.Component;

@Service
public class ComponentServiceImpl implements ComponentService{

	@Autowired
	ComponentRepository componentRepository;
	
	@Override
	public List<ComponentDto> getAll() {
		return componentRepository.findAll().stream().map(Component::toDto).collect(Collectors.toList());
	}

	@Override
	public ComponentDto get(Long id) {
		Optional<Component> component = componentRepository.findById(id);
		return component.isPresent()? component.get().toDto(): null;
	}

	@Override
	public ComponentDto insert(ComponentDto componentDto) {
		if(componentDto.getComponentId() != null)
			throw new RuntimeException();
		return componentRepository.save(componentDto.toModel()).toDto();
	}

	@Override
	public ComponentDto update(ComponentDto componentDto) {
		if(componentDto.getComponentId() == null)
			throw new RuntimeException();
			return componentRepository.save(componentDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		componentRepository.deleteById(id);
		return componentRepository.findById(id).isEmpty();
	}

	@Override
	public List<ComponentDto> getComponentByName(String name) {
		return componentRepository.findComponentByName(name).stream().map(Component::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ComponentDto> getComponentByChemicalRisk(String chemicalRisk) {
		return componentRepository.findComponentByChemicalRisk(chemicalRisk).stream().map(Component::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ComponentDto> getComponentByTypeChemicalRisk(String typeChemicalRisk) {
		return componentRepository.findComponentByTypeChemicalRisk(typeChemicalRisk).stream().map(Component::toDto).collect(Collectors.toList());
	}

	@Override
	public List<ComponentDto> getComponentByExpirationDate(Instant expirationDate) {
		return componentRepository.findComponentByExpirationDate(expirationDate).stream().map(Component::toDto).collect(Collectors.toList());
	}

	@Override
	public Long getTotalComponentRows() {
		return componentRepository.getComponentTotalRows();
	}

	@Override
	public Long getTotalComponentRowsDeleted() {
		// TODO Auto-generated method stub
		return componentRepository.getComponentTotalRowsDeleted();
	}

	@Override
	public Long getTotalComponentRowsNotDeleted() {
		// TODO Auto-generated method stub
		return componentRepository.getComponentTotalRowsNotDeleted();
	}

}
