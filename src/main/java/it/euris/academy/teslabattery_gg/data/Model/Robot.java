package it.euris.academy.teslabattery_gg.data.Model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import it.euris.academy.teslabattery_gg.Enums.RobotFunction;
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
public class Robot {

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
	
	
	
	
	
	
	
	
	
	
	
	

}
