package it.euris.academy.teslabattery_gg.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import it.euris.academy.teslabattery_gg.data.Dto.BatteryDto;

public interface BatteryService {

	public List<BatteryDto> getAll();
	public BatteryDto get(Long id);
	public BatteryDto insert(BatteryDto batteryDto);
	public BatteryDto update(BatteryDto batteryDto);
	public Boolean delete(Long id);
	
	public List<BatteryDto> getBatteryByName(String name);
	public List<BatteryDto> getBatteryByCreationDate(Instant creationDate);
	public List<BatteryDto> getBatteryByExpirationDate(Instant expirationDate);
	
	public Long getTotalBatteryRows();
	public Long getTotalBatteryRowsDeleted();
	public Long getTotalBatteryRowsNotDeleted();
}
