package it.euris.academy.teslabattery_gg.data.Dto;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import it.euris.academy.teslabattery_gg.Utilities.UT;
import it.euris.academy.teslabattery_gg.data.Archetype.Dto;
import it.euris.academy.teslabattery_gg.data.Model.AssemblyChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssemblyChainDto implements Dto {

	private String assemblyChainId;
	private String assemblyChainName;
	private String assemblyChainCompetationTime;

	@Override
	public AssemblyChain toModel() {
		Date d;
		try {
			d = UT.StringToDate(assemblyChainCompetationTime);
			UT.addDays(d, 1);
			Instant d_1 = UT.DateToInstant(d);
			return AssemblyChain.builder().
					id(UT.toLong(assemblyChainId))
					.name(assemblyChainName)
					.completationTime(d_1)
					.build();
		} 
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
