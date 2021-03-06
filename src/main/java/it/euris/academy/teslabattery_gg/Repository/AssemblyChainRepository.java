package it.euris.academy.teslabattery_gg.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.teslabattery_gg.data.Model.AssemblyChain;

public interface AssemblyChainRepository extends JpaRepository<AssemblyChain, Long> {

	public AssemblyChain findAssemblyChainById(@Param("id") Long id);
	public List<AssemblyChain> findAssemblyChainByName(@Param("name") String name);
	public List<AssemblyChain> findAssemblyChainByCompletationTime(@Param("completationTime") Instant completationTime);
	
	@Query(value = "SELECT COUNT(*) FROM assembly_chain", nativeQuery = true)
	Long getAssemblyChainTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM assembly_chain WHERE deleted = true", nativeQuery = true)
	Long getAssemblyChainTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM assembly_chain WHERE deleted = false", nativeQuery = true)
	Long getAssemblyChainTotalRowsNotDeleted();
}
