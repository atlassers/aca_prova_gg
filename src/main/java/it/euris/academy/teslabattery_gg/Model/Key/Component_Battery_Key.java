package it.euris.academy.teslabattery_gg.Model.Key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Component_Battery_Key implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "component_id")
	Long componentId;
	
	@Column(name = "battery_id")
	Long batteryId;
}
