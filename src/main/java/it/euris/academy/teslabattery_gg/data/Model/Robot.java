package it.euris.academy.teslabattery_gg.data.Model;

import java.time.Instant;
import java.util.HashSet;

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
@Table(name = "robots")
@Entity
@SQLDelete(sql = "UPDATE robots SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Robot implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "robot_code")
	private String robotCode;

	@Column(name = "creation_Date")
	private Instant creationDate;

	/*
	 * potrei fare nella colonna robot_assemblyChain un valore positionaOrder come
	 * rating in studentCourse
	 * 
	 * @Column(name = "positional_Order") 
	 * private Long positionalOrder;
	 */

	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;

	@Column(name = "function")
	@Enumerated(value = EnumType.STRING)
	private RobotFunction function;
	
	@OneToMany(mappedBy = "robots")
	@Builder.Default
	@JsonIgnore
	private HashSet<Robot_AssemblyChain> robot_AssemblyChain = 
	new HashSet<Robot_AssemblyChain>();

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
