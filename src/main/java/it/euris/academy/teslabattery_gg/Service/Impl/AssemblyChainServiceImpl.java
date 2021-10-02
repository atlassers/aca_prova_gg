package it.euris.academy.teslabattery_gg.Service.Impl;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.euris.academy.teslabattery_gg.Repository.AssemblyChainRepository;
import it.euris.academy.teslabattery_gg.Service.AssemblyChainService;
import it.euris.academy.teslabattery_gg.data.Dto.AssemblyChainDto;
import it.euris.academy.teslabattery_gg.data.Model.AssemblyChain;

@Service
public class AssemblyChainServiceImpl implements AssemblyChainService {

	@Autowired
	AssemblyChainRepository assemblyChainRepository; 
	
	@Override
	public List<AssemblyChainDto> getAll() {
		return assemblyChainRepository.findAll().stream().map(AssemblyChain::toDto).collect(Collectors.toList());
	}

	@Override
	public AssemblyChainDto get(Long id) {
		Optional<AssemblyChain> assemblyChain = assemblyChainRepository.findById(id);
		return assemblyChain.isPresent() ? assemblyChain.get().toDto():null ;
	}

	@Override
	public AssemblyChainDto insert(AssemblyChainDto assemblyChainDto) {
		if(assemblyChainDto.getAssemblyChainId() != null)
			throw new RuntimeException();
		
		return assemblyChainRepository.save(assemblyChainDto.toModel()).toDto();
	}

	@Override
	public AssemblyChainDto update(AssemblyChainDto assemblyChainDto) {
		if(assemblyChainDto.getAssemblyChainId() == null)
			throw new RuntimeException();
		
		return assemblyChainRepository.save(assemblyChainDto.toModel()).toDto();
	}

	@Override
	public Boolean delete(Long id) {
		assemblyChainRepository.deleteById(id);
		return assemblyChainRepository.findById(id).isEmpty();
	}

	@Override
	public List<AssemblyChainDto> getAssemblyChainByName(String name) {
		return assemblyChainRepository.findAssemblyChainByName(name).stream().map(AssemblyChain::toDto).collect(Collectors.toList());
	}

	@Override
	public List<AssemblyChainDto> getAssemblyChainByCompletationTime(Instant completationTime) {
		return assemblyChainRepository.findAssemblyChainByCompletationTime(completationTime).stream().map(AssemblyChain::toDto).collect(Collectors.toList());
	}

	@Override
	public Long getTotalAssemblyChainRows() {
		return assemblyChainRepository.getAssemblyChainTotalRows();
	}

	@Override
	public Long getTotalAssemblyChainRowsDeleted() {
		return assemblyChainRepository.getAssemblyChainTotalRowsDeleted();
	}

	@Override
	public Long getTotalAssemblyChainRowsNotDeleted() {
		return assemblyChainRepository.getAssemblyChainTotalRowsNotDeleted();
	}

}
