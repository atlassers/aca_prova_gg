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
public class Robot_AssemblyChain_Key implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "robot_id")
	Long robotsId;
	
	@Column(name = "assemblyChain_id")
	Long assemblyChainId;
}
