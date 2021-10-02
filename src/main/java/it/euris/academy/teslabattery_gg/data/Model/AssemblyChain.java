package it.euris.academy.teslabattery_gg.data.Model;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.euris.academy.teslabattery_gg.data.Archetype.Model;
import it.euris.academy.teslabattery_gg.data.Dto.AssemblyChainDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "assemblyChain")
@SQLDelete(sql = "UPDATE assemblyChain SET deleted = true WHERE id=? ")
@Where(clause = "deleted = false")
@Entity
public class AssemblyChain implements Model {
	
	// nome, tempo di completamento max, 
	// composta da diversi robot che a loro volta possono avere + catene
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column (name = "completation_time")
	private Instant completationTime;
	
	/*
	 * 
	 */
	@OneToMany(mappedBy = "assemblyChain")
	@Builder.Default
	@JsonIgnore
	private Set<Robot_AssemblyChain> robot_AssemblyChain 
	= new HashSet<Robot_AssemblyChain>();
	
	public AssemblyChain(String assemblyChainId) {
		this.id = Long.parseLong(assemblyChainId);
	}
	
	@Override
	public AssemblyChainDto toDto() {
		
		return AssemblyChainDto.builder()
				.assemblyChainId(id.toString())
				.assemblyChainName(name)
				.assemblyChainCompetationTime(completationTime.toString())
				.build();
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
