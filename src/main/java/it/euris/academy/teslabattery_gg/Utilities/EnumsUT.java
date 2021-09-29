package it.euris.academy.teslabattery_gg.Utilities;

import it.euris.academy.teslabattery_gg.Enums.ChemicalRisk;
import it.euris.academy.teslabattery_gg.Enums.TypeChemicalRisk;

public class EnumsUT {

	public static String toString(ChemicalRisk value) {
		return value == null ? null : value.name();
	}

	public static ChemicalRisk getChemicalRisk(String value) {
		if (value == null) {
			return null;
		}
		for (ChemicalRisk type : ChemicalRisk.values()) {
			if (type.name().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
	
	public static String toString(TypeChemicalRisk value) {
		return value == null ? null : value.name();
	}

	public static TypeChemicalRisk getTypeChemicalRisk(String value) {
		if (value == null) {
			return null;
		}
		for (TypeChemicalRisk type : TypeChemicalRisk.values()) {
			if (type.name().equals(value)) {
				return type;
			}
		}
		return null;
	}
	
}
