package it.euris.academy.teslabattery_gg.data.Dto;

import it.euris.academy.teslabattery_gg.Model.Key.Component_Battery_Key;
import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Model.Battery;
import it.euris.academy.teslabattery_gg.data.Model.Component;
import it.euris.academy.teslabattery_gg.data.Model.Component_Battery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Component_Battery_Dto implements Dto {

	private Component_Battery_Key component_Battery_Dto_Id;
	private String componentId;
	private String batteryId;
	
	@Override
	public Model toModel() {
		return Component_Battery.builder()
				.id(new Component_Battery_Key(UT.toLong(componentId), UT.toLong(batteryId)))
				.component(new Component(componentId))
				.battery(new Battery(batteryId))
				.build();
	}
}
