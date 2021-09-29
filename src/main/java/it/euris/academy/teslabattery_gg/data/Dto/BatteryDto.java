package it.euris.academy.teslabattery_gg.data.Dto;

import java.time.Instant;

import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Model.Battery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteryDto implements Dto {
	private String batteryId;
	private String batteryName;
	private String batteryCreationDate;
	private String batteryExpirationDate;
	
	@Override
	public Battery toModel() {
		return Battery.builder()
				.id(UT.toLong(batteryId))
				.name(batteryName)
				.creationDate(Instant.parse(batteryCreationDate))
				.expirationDate(Instant.parse(batteryExpirationDate))
				.build();
	}	
}
