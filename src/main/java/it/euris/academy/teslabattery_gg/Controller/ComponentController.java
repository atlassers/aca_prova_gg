package it.euris.academy.teslabattery_gg.Controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.euris.academy.teslabattery_gg.Repository.Projection.ComponentsByBattery;
import it.euris.academy.teslabattery_gg.Service.ComponentService;
import it.euris.academy.teslabattery_gg.data.Dto.ComponentDto;

@RestController
@RequestMapping("/components")
@ResponseStatus(HttpStatus.CREATED)
public class ComponentController {

	@Autowired
	ComponentService componentService;
	
	@GetMapping("/v1/componentsByBattery/components/{id}")
	public List<ComponentsByBattery> getComponentsByBattery(@PathVariable("id") Long id){
		return componentService.getTotalComponentByBattery(id);
	}
	
	@GetMapping("/v1/total")
	public Long getTotalComponentRows() {
		return componentService.getTotalComponentRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalComponentRowsDeleted() {
		return componentService.getTotalComponentRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalComponentRowsNotDeleted() {
		return componentService.getTotalComponentRowsNotDeleted();
	}
	
	@GetMapping("/v1")
	public List<ComponentDto> getAll(){
		return componentService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public ComponentDto getById(@PathVariable("id") Long id) {
		return componentService.get(id);
	}
	
	@GetMapping("/v1/name/{name}")
	public List<ComponentDto> getByName(@PathVariable("name") String name){
		return componentService.getComponentByName(name);
	}
	
	@GetMapping("/v1/chemicalRisk/{chemicalRisk}")
	public List<ComponentDto> getByChemicalRisk(@PathVariable("chemicalRisk") String chemicalRisk){
		return componentService.getComponentByChemicalRisk(chemicalRisk);
	}
	
 	@GetMapping("/v1/typeChemicalRisk/{typeChemicalRisk}")
	public List<ComponentDto> getByTypeChemicalRisk(@PathVariable("typeChemicalRisk")String typeChemicalRisk){
		return componentService.getComponentByTypeChemicalRisk(typeChemicalRisk);
	}
 	
 	@GetMapping("/v1/expirationDate/{expirationDate}")
	public List<ComponentDto> getByExpirationDate(@PathVariable("typeChemicalRisk")Instant expirationDate){
		return componentService.getComponentByExpirationDate(expirationDate);
	}
 	
	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return componentService.delete(id);
	}
	
	@PutMapping("/v1")
	public ComponentDto update(@RequestBody ComponentDto componentDto) {
		return componentService.update(componentDto);
	}
	
	@PatchMapping("/v1")
	public ComponentDto patch(@RequestBody ComponentDto componentDto) {
		return componentService.update(componentDto);
	}
	
	@PostMapping("/v1")
	public ComponentDto insert(@RequestBody ComponentDto componentDto) {
		return componentService.insert(componentDto);
	}
 	
}
