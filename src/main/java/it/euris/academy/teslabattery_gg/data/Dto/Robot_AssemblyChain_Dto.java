package it.euris.academy.teslabattery_gg.data.Dto;

import it.euris.academy.teslabattery_gg.Model.Key.Robot_AssemblyChain_Key;
import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Model.AssemblyChain;
import it.euris.academy.teslabattery_gg.data.Model.Robot;
import it.euris.academy.teslabattery_gg.data.Model.Robot_AssemblyChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Robot_AssemblyChain_Dto implements Dto {
	
	private Robot_AssemblyChain_Key robot_AssemblyChain_Dto_Id;
	private String robotId;
	private String assemblyChainId;
	private String robotPosition;
	
	@Override
	public Robot_AssemblyChain toModel() {
		return Robot_AssemblyChain.builder()
				.id(new Robot_AssemblyChain_Key(UT.toLong(robotId), UT.toLong(assemblyChainId)))
				.robot(new Robot(robotId))
				.assemblyChain(new AssemblyChain(assemblyChainId))
				.robotPosition(UT.toLong(robotPosition))
				.build();
	}

}
