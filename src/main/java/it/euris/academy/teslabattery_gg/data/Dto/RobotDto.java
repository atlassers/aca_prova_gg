package it.euris.academy.teslabattery_gg.data.Dto;

import java.time.Instant;

import it.euris.academy.teslabattery_gg.Utilities.EnumsUT;
import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Model.Robot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RobotDto implements Dto{
	
	private String robotId;
	private String robotCode;
	private String robotCreationDate;
	private String robotFunction;
	
	@Override
	public Robot toModel() {
		return Robot.builder()
				.id(UT.toLong(robotId))
				.robotCode(robotCode)
				.creationDate(Instant.parse(robotCreationDate))
				.function(EnumsUT.getRobotFunction(robotFunction))
				.build();
	}
}
