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

import it.euris.academy.teslabattery_gg.Enums.ChemicalRisk;
import it.euris.academy.teslabattery_gg.Enums.TypeChemicalRisk;
import it.euris.academy.teslabattery_gg.Utilities.EnumsUT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.ComponentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "component")
@Entity
@SQLDelete(sql = "UPDATE components SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Component implements Model {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "expiration_date")
	private Instant expirationDate;

	@Column(name = "chemical_risk")
	@Enumerated(value = EnumType.STRING)
	private ChemicalRisk chemicalRisk;

	@Column(name = "type_chemical_risk")
	@Enumerated(value = EnumType.STRING)
	private TypeChemicalRisk typeChemicalRisk;

	@Column(name = "deleted")
	@Builder.Default
	private Boolean deleted = false;

	
	@OneToMany(mappedBy = "component")
	@Builder.Default
	@JsonIgnore 
	private Set<Component_Battery> comp_Battery = new HashSet<Component_Battery>();
	 
	
	public Component(String componentId) {
		this.id = Long.valueOf(componentId);
	}

	@Override
	public ComponentDto toDto() {
		return ComponentDto.builder().componentId(id.toString()).componentName(name)
				.componentExpirationDate(expirationDate.toString())
				.componentChemicalRisk(EnumsUT.toString(chemicalRisk))
				.componentTypeChemicalRisk(EnumsUT.toString(typeChemicalRisk))
				.build();
	}

}
