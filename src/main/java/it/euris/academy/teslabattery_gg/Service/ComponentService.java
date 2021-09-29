package it.euris.academy.teslabattery_gg.Service;

import java.time.Instant;
import java.util.List;

import it.euris.academy.teslabattery_gg.data.Dto.ComponentDto;

public interface ComponentService {

	public List<ComponentDto> getAll();
	public ComponentDto get(Long id);
	public ComponentDto insert(ComponentDto componentDto);
	public ComponentDto update(ComponentDto componentDto);
	public Boolean delete(Long id);
	
	public List<ComponentDto> getComponentByName(String name);
	public List<ComponentDto> getComponentByChemicalRisk(String chemicalRisk);
	public List<ComponentDto> getComponentByTypeChemicalRisk(String typeChemicalRisk);
	public List<ComponentDto> getComponentByExpirationDate(Instant expirationDate);
	
	public Long getTotalComponentRows();
	public Long getTotalComponentRowsDeleted();
	public Long getTotalComponentRowsNotDeleted();
}
