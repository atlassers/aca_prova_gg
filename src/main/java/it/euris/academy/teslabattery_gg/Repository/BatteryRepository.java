package it.euris.academy.teslabattery_gg.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.teslabattery_gg.data.Model.Battery;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

	public Battery findBatteryById(@Param("id") Long id);
	public List<Battery> findBatteryByName(@Param("name") String name);
	public List<Battery> findBatteryByCreationDate(@Param("creationDate") Instant creationDate);
	public List<Battery> findBatteryByExpirationDate(@Param("expirationDate") Instant expirationDate);
	
	@Query(value = "SELECT COUNT(*) FROM batteries", nativeQuery = true)
	Long getBatteryTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM batteries WHERE deleted = true", nativeQuery = true)
	Long getBatteryTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM batteries WHERE deleted = false", nativeQuery = true)
	Long getBatteryTotalRowsNotDeleted();
}
