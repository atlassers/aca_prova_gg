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

import it.euris.academy.teslabattery_gg.Service.AssemblyChainService;
import it.euris.academy.teslabattery_gg.data.Dto.AssemblyChainDto;

@RestController
@RequestMapping("/assemblyChain")
@ResponseStatus(HttpStatus.CREATED)
public class AssemblyChainController {
	
	@Autowired
	AssemblyChainService assemblyChainService;
	
	@GetMapping("/v1/total")
	public Long getTotalAssemblyChainDtoRows() {
		return assemblyChainService.getTotalAssemblyChainRows();
	}
	
	@GetMapping("/v1/total-deleted")
	public Long getTotalAssemblyChainDtoRowsDeleted() {
		return assemblyChainService.getTotalAssemblyChainRowsDeleted();
	}
	
	@GetMapping("/v1/total-undeleted")
	public Long getTotalAssemblyChainDtoRowsNotDeleted() {
		return assemblyChainService.getTotalAssemblyChainRowsNotDeleted();
	}
	
	@GetMapping("/v1")
	public List<AssemblyChainDto> getAll(){
		return assemblyChainService.getAll();
	}
	
	@GetMapping("/v1/{id}")
	public AssemblyChainDto getById(@PathVariable("id") Long id) {
		return assemblyChainService.get(id);
	}
	
	@GetMapping("/v1/name/{name}")
	public List<AssemblyChainDto> getByName(@PathVariable("name") String name){
		return assemblyChainService.getAssemblyChainByName(name);
	}
	
 	@GetMapping("/v1/completationTime/{completationTime}")
	public List<AssemblyChainDto> getByCompletationTime(@PathVariable("completationTime")Instant completationTime){
		return assemblyChainService.getAssemblyChainByCompletationTime(completationTime);
	}
 	
 	@DeleteMapping("/v1/{id}")
	public Boolean delete(@PathVariable("id") Long id) {
		return assemblyChainService.delete(id);
	}
	
	@PutMapping("/v1/update/{assemblyChainDto}")
	public AssemblyChainDto update(@RequestBody AssemblyChainDto AssemblyChainDto) {
		return assemblyChainService.update(AssemblyChainDto);
	}
	
	@PatchMapping("/v1")
	public AssemblyChainDto patch(@RequestBody AssemblyChainDto AssemblyChainDto) {
		return assemblyChainService.update(AssemblyChainDto);
	}
	
	@PostMapping("/v1")
	public AssemblyChainDto insert(@RequestBody AssemblyChainDto AssemblyChainDto) {
		return assemblyChainService.insert(AssemblyChainDto);
	}

}
