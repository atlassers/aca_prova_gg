package it.euris.academy.teslabattery_gg.data.Dto;

import java.time.Instant;

import it.euris.academy.teslabattery_gg.Utilities.EnumsUT;
import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Model.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComponentDto implements Dto {

	private String componentId;
	private String componentName;
	private String componentExpirationDate;
	private String componentChemicalRisk;
	private String componentTypeChemicalRisk;

	@Override
	public Component toModel() {
		return Component.builder().id(UT.toLong(componentId))
				.name(componentName)
				.expirationDate(Instant.parse(componentExpirationDate))
				.chemicalRisk(EnumsUT.getChemicalRisk(componentChemicalRisk))
				.typeChemicalRisk(EnumsUT.getTypeChemicalRisk(componentTypeChemicalRisk))
				.build();
	}
}
