package it.euris.academy.teslabattery_gg.data.Model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.euris.academy.teslabattery_gg.Enums.RobotFunction;
import it.euris.academy.teslabattery_gg.Utilities.EnumsUT;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.RobotDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "robot")
@SQLDelete(sql = "UPDATE robot SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@Entity
public class Robot implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "robot_code")
	private String robotCode;

	@Column(name = "creation_Date")
	private Instant creationDate;
	
	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;

	@Column(name = "robot_function")
	@Enumerated(value = EnumType.STRING)
	private RobotFunction function;
	
	@OneToMany(mappedBy = "robot")
	@Builder.Default
	@JsonIgnore
	private Set<Robot_AssemblyChain> robot_AssemblyChain = new HashSet<Robot_AssemblyChain>();

	public Robot(String robotId) {
		if(robotId != null) {
			this.id = Long.parseLong(robotId);
		}
	}
	
	@Override
	public RobotDto toDto() {
		return RobotDto.builder()
				.robotId(id.toString())
				.robotCode(robotCode)
				.robotCreationDate(creationDate.toString())
				.robotFunction(EnumsUT.toString(function))
				.build();
	}
}
