package it.euris.academy.teslabattery_gg.Service;

import java.time.Instant;
import java.util.List;

import it.euris.academy.teslabattery_gg.data.Dto.AssemblyChainDto;
import it.euris.academy.teslabattery_gg.data.Model.AssemblyChain;

public interface AssemblyChainService {

	public List<AssemblyChainDto> getAll();
	public AssemblyChainDto get(Long id);
	public AssemblyChainDto insert(AssemblyChainDto assemblyChainDto);
	public AssemblyChainDto update(AssemblyChainDto assemblyChainDto);
	public Boolean delete(Long id);
	
	public AssemblyChain getAssemblyChainById(Long id);
	public List<AssemblyChainDto> getAssemblyChainByName(String name);
	public List<AssemblyChainDto> getAssemblyChainByCompletationTime(Instant completationTime);
}
