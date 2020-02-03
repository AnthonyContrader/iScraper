package it.contrader.converter;

import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;

import java.util.ArrayList;
import java.util.List;


public class InjuryConverter implements Converter<Injury, InjuryDTO> {

	
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
		return new InjuryDTO(injury.getId(),injury.getSeverity(),injury.getDescription(),injury.getDuration(),injury.getDate(),injury.getPlayer_id());
	}
	
	public Injury toEntity(InjuryDTO dto) {
		return new Injury(dto.getId(),dto.getSeverity(),dto.getDescription(),dto.getDuration(),dto.getDate(), dto.getPlayer_id());
	}
}
