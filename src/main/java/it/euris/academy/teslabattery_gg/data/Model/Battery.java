package it.euris.academy.teslabattery_gg.data.Model;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.BatteryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "battery")
@SQLDelete(sql = "UPDATE batteries SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
@Entity
public class Battery implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "creation_date")
	private Instant creationDate;

	@Column(name = "expiration_date")
	private Instant expirationDate;

	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;
	

	@OneToMany(mappedBy = "battery")
	@Builder.Default
	@JsonIgnore
	private Set<Component_Battery> component_Battery = new HashSet<Component_Battery>();
	
	
	public Battery(String batteryId) {
		this.id = Long.valueOf(batteryId);
	}
	
	@Override
	public BatteryDto toDto() {
		return BatteryDto.builder()
				.batteryId(id.toString())
				.batteryName(name)
				.batteryCreationDate(creationDate.toString())
				.batteryExpirationDate(expirationDate.toString())
				.build();	
	}	
}
