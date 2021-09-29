package it.euris.academy.teslabattery_gg.data.Dto;

import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
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
	public Model toModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
