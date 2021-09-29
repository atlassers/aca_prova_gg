package it.euris.academy.teslabattery_gg.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.teslabattery_gg.Repository.Projection.ComponentsByBattery;
import it.euris.academy.teslabattery_gg.data.Model.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {

	public Component findComponentById(@Param("id") Long id);
	public List<Component> findComponentByChemicalRisk(@Param("chemicalRisk") String chemicalRisk);
	public List<Component> findComponentByTypeChemicalRisk(@Param("typeChemicalRisk") String typeChemicalRisk);
	public List<Component> findComponentByName(@Param("name") String name);
	public List<Component> findComponentByExpirationDate(@Param("expirationDate") Instant expirationDate);
	
	@Query(value = "SELECT COUNT(*) FROM components", nativeQuery = true)
	Long getComponentTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM components WHERE deleted = true", nativeQuery = true)
	Long getComponentTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM components WHERE deleted = false", nativeQuery = true)
	Long getComponentTotalRowsNotDeleted();
	
	@Query(value = "SELECT COUNT(IF(component_id =:id, 1, NULL)) AS totalComponentsByBattery FROM academy_teslabattery_gg.component_battery ", nativeQuery = true)
	public List<ComponentsByBattery> getComponentsByBattery(@Param("id") Long id );
}
