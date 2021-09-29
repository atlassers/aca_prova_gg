package it.euris.academy.teslabattery_gg.Service;

import java.time.Instant;
import java.util.List;

import it.euris.academy.teslabattery_gg.data.Dto.RobotDto;


public interface RobotService {

	public List<RobotDto> getAll();
	public RobotDto get(Long id);
	public RobotDto insert(RobotDto robotDto);
	public RobotDto update(RobotDto robotDto);
	public Boolean delete(Long id);
	
	public List<RobotDto> getRobotByRobotCode(String robotCode);
	public List<RobotDto> getRobotByFunction(String function);
	public List<RobotDto> getRobotByCreationDate(Instant creationDate);
	
	public Long getTotalRobotRows();
	public Long getTotalRobotRowsDeleted();
	public Long getTotalRobotRowsNotDeleted();
}
