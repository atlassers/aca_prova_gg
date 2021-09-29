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

import it.euris.academy.teslabattery_gg.Service.RobotService;
import it.euris.academy.teslabattery_gg.data.Dto.RobotDto;

@RestController
@RequestMapping("/robots")
@ResponseStatus(HttpStatus.CREATED)
public class RobotController {

	@Autowired
	RobotService robotService;
	
	@GetMapping("/v1/total")
	public Long getTotalRobotRows() {
		return robotService.getTotalRobotRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalRobotRowsDeleted() {
		return robotService.getTotalRobotRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalRobotRowsNotDeleted() {
		return robotService.getTotalRobotRowsNotDeleted();
	}
	
	@GetMapping("/v1")
	public List<RobotDto> getAll(){
		return robotService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public RobotDto getById(@PathVariable("id") Long id) {
		return robotService.get(id);
	}
	
	@GetMapping("/v1/robotCode/{robotCode}")
	public List<RobotDto> getByName(@PathVariable("robotCode") String robotCode){
		return robotService.getRobotByRobotCode(robotCode);
	}
	
	@GetMapping("/v1/function/{function}")
	public List<RobotDto> getByChemicalRisk(@PathVariable("function") String function){
		return robotService.getRobotByFunction(function);
	}
	
 	@GetMapping("/v1/creationDate/{creationDate}")
	public List<RobotDto> getByTypeChemicalRisk(@PathVariable("creationDate")Instant creationDate){
		return robotService.getRobotByCreationDate(creationDate);
	}
 	
 	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return robotService.delete(id);
	}
	
	@PutMapping("/v1")
	public RobotDto update(@RequestBody RobotDto robotDto) {
		return robotService.update(robotDto);
	}
	
	@PatchMapping("/v1")
	public RobotDto patch(@RequestBody RobotDto robotDto) {
		return robotService.update(robotDto);
	}
	
	@PostMapping("/v1")
	public RobotDto insert(@RequestBody RobotDto robotDto) {
		return robotService.insert(robotDto);
	}
}
