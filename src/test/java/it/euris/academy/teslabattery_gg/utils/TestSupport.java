package it.euris.academy.teslabattery_gg.utils;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;

import it.euris.academy.teslabattery_gg.Enums.ChemicalRisk;
import it.euris.academy.teslabattery_gg.Enums.TypeChemicalRisk;
import it.euris.academy.teslabattery_gg.data.Model.Component;
import it.euris.academy.teslabattery_gg.data.Model.Component_Battery;

public class TestSupport {
	
	public static Component createComponent(Long id) {

		var comBatt = new HashSet<Component_Battery>();
		
		return Component.builder()
		.comp_Battery(comBatt)
		.deleted(Boolean.FALSE)
		.chemicalRisk(ChemicalRisk.HIGH_DANGER)
		.typeChemicalRisk(TypeChemicalRisk.TOXIC)
		.expirationDate(Instant.MAX)
		.name("fghj")
		.id(id).build();
		
	}
	
	public static List<Component> createComponentList(){
		return List.of(createComponent(1L), createComponent(2L));
	}
	
	
	

}
