package it.euris.academy.teslabattery_gg.Repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.euris.academy.teslabattery_gg.data.Model.Robot;

public interface RobotRepository extends JpaRepository<Robot, Long>  {
	
	public Robot findRobotById(@Param("id") Long id);
	public List<Robot> findRobotByRobotCode(@Param("robotCode") String robotCode);
	public List<Robot> findRobotByFunction(@Param("function") String function);
	public List<Robot> findRobotByCreationDate(@Param("creationDate") Instant creationDate);
	
	@Query(value = "SELECT COUNT(*) FROM robots", nativeQuery = true)
	Long getRobotTotalRows();
	
	@Query(value = "SELECT COUNT(*) FROM robots WHERE deleted = true", nativeQuery = true)
	Long getRobotTotalRowsDeleted();
	
	@Query(value = "SELECT COUNT(*) FROM robots WHERE deleted = false", nativeQuery = true)
	Long getRobotTotalRowsNotDeleted();
	
}
