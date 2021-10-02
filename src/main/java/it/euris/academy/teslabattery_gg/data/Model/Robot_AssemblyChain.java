package it.euris.academy.teslabattery_gg.data.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.euris.academy.teslabattery_gg.Model.Key.Robot_AssemblyChain_Key;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.Robot_AssemblyChain_Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "robot_assemblyChain")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Robot_AssemblyChain implements Model{

	@EmbeddedId
	private Robot_AssemblyChain_Key id;
	
	@ManyToOne
	@MapsId("robotId")
	@JoinColumn(name = "robot_id")
	private Robot robot;
	
	@ManyToOne
	@MapsId("assemblyChainId")
	@JoinColumn(name = "assemblyChain_id")
	private AssemblyChain assemblyChain;
	
	@Column(name = "robot_position")
	private Long robotPosition;

	@Override
	public Robot_AssemblyChain_Dto toDto() {
		return Robot_AssemblyChain_Dto.builder()
				.robot_AssemblyChain_Dto_Id(id)
				.robotId(robot.getId().toString())
				.assemblyChainId(assemblyChain.getId().toString())
				.robotPosition(robotPosition.toString())
				.build();
	}
	
	
	
	
	
	
	
	
}
