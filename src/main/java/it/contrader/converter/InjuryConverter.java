package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;

public class InjuryConverter {
	
	public InjuryConverter() {
		
	}
	
	public List<InjuryDTO> toDTOList(List<Injury> injuryList) {
		ArrayList<InjuryDTO> dtoList = new ArrayList<InjuryDTO>();
		
		for (Injury injury : injuryList) {
			dtoList.add(this.toDTO(injury));
		}
		
		return dtoList;
	}
	
	public InjuryDTO toDTO(Injury injury) {
		return new InjuryDTO(injury.getPlayerID(),injury.getTypology(),injury.getDuration(),injury.getGravityIndex(),injury.getSeason());
	}
	
	public Injury toEntity(InjuryDTO dto) {
		return new Injury(dto.getPlayerID(),dto.getTypology(),dto.getDuration(),dto.getGravityIndex(),dto.getSeason());
	}
}
