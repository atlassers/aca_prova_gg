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

import it.euris.academy.teslabattery_gg.Service.BatteryService;
import it.euris.academy.teslabattery_gg.data.Dto.BatteryDto;

@RestController
@RequestMapping("/battery")
@ResponseStatus(HttpStatus.CREATED)
public class BatteryController {

	@Autowired
	BatteryService batteryService;
	
	@GetMapping("/v1/total")
	public Long getTotalBookRows() {
		return batteryService.getTotalBatteryRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalBookRowsDeleted() {
		return batteryService.getTotalBatteryRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalBookRowsNotDeleted() {
		return batteryService.getTotalBatteryRowsNotDeleted();
	}
	
	@GetMapping("/v1")
	public List<BatteryDto> getAll(){
		return batteryService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public BatteryDto getById(@PathVariable("id") Long id) {
		return batteryService.get(id);
	}
	
	@GetMapping("/v1/name/{name}")
	public List<BatteryDto> getByName(@PathVariable("robotCode") String name){
		return batteryService.getBatteryByName(name);
	}
	
	@GetMapping("/v1/function/{function}")
	public List<BatteryDto> getByChemicalRisk(@PathVariable("creationDate") Instant creationDate){
		return batteryService.getBatteryByCreationDate(creationDate);
	}
	
 	@GetMapping("/v1/creationDate/{creationDate}")
	public List<BatteryDto> getByTypeChemicalRisk(@PathVariable("expirationDate")Instant expirationDate){
		return batteryService.getBatteryByExpirationDate(expirationDate);
	}
 	
 	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return batteryService.delete(id);
	}
	
	@PutMapping("/v1/update/{battery}")
	public BatteryDto update(@RequestBody BatteryDto batteryDto) {
		return batteryService.update(batteryDto);
	}
	
	@PatchMapping("/v1")
	public BatteryDto patch(@RequestBody BatteryDto batteryDto) {
		return batteryService.update(batteryDto);
	}
	
	@PostMapping("/v1")
	public BatteryDto insert(@RequestBody BatteryDto batteryDto) {
		return batteryService.insert(batteryDto);
	}
}
