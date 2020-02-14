package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;
import java.util.List;
import java.util.ArrayList;

@Component
public class InjuryConverter extends AbstractConverter<Injury, InjuryDTO>{

	@Override
	public Injury toEntity(InjuryDTO injuryDTO) {
		Injury injury = null;
		if (injuryDTO!=null) {
			injury = new Injury(injuryDTO.getId(), injuryDTO.getSeverity(), injuryDTO.getDescription(), injuryDTO.getDuration(), injuryDTO.getDate(), injuryDTO.getPlayer());
		}
		return injury;
	}
	
	@Override
	public InjuryDTO toDTO(Injury injury) {
		InjuryDTO injuryDTO = null;
		if (injury!=null) {
			injuryDTO = new InjuryDTO(injury.getId(), injury.getSeverity(), injury.getDescription(), injury.getDuration(), injury.getDate(), injury.getPlayer());
		}
		return injuryDTO;
	}
	
	public List<InjuryDTO> toListDTO(List<Injury> injuryList) {
		List<InjuryDTO> injuryDTOlist = new ArrayList<InjuryDTO>();
		for (Injury injury : injuryList) {
			injuryDTOlist.add(toDTO(injury));
		}
		return injuryDTOlist;
	}
}
