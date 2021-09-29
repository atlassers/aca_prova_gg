package it.euris.academy.teslabattery_gg.data.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import it.euris.academy.teslabattery_gg.Model.Key.Component_Battery_Key;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.Component_Battery_Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "component_battery")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Component_Battery implements Model  {

	@EmbeddedId
	private Component_Battery_Key id;
	
	@ManyToOne
	@MapsId("componentId")
	@JoinColumn(name = "component_id")
	private Component component;
	
	@ManyToOne
	@MapsId("batteryId")
	@JoinColumn(name = "battery_id")
	private Battery battery;

	@Override
	public Component_Battery_Dto toDto() {
		return Component_Battery_Dto.builder()
				.component_Battery_Dto_Id(id)
				.componentId(component.getId().toString())
				.batteryId(battery.getId().toString())
				.build();
	}	
	
}
