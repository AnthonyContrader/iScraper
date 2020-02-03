package it.contrader.converter;

import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Statsbox;

import java.util.ArrayList;
import java.util.List;


public class StatsboxConverter implements Converter <Statsbox, StatsboxDTO>{
	
	public StatsboxConverter() {
		
	}

	public List<StatsboxDTO> toDTOList(List<Statsbox> statsboxList) {
		ArrayList<StatsboxDTO> dtoList = new ArrayList<StatsboxDTO>();
		
		for (Statsbox statsbox : statsboxList) {
			dtoList.add(this.toDTO(statsbox));
		}
		
		return dtoList;
	}

	public StatsboxDTO toDTO(Statsbox statsbox) {
		return new StatsboxDTO(statsbox.getId(), statsbox.getPlayerId(),statsbox.getSeason(),statsbox.getTeam(), statsbox.getCaps(), statsbox.getContributions(), statsbox.getShotsper(), statsbox.getKeypass(), statsbox.getPassprec(), statsbox.getDribbling(), statsbox.getFoulssub(), statsbox.getFoulscomm(), statsbox.getTackles(), statsbox.getTacklesper(), statsbox.getBreaks());
	}
	
	public Statsbox toEntity(StatsboxDTO dto) {
		return new Statsbox(dto.getId(), dto.getPlayerId(),dto.getSeason(),dto.getTeam(), dto.getCaps(), dto.getContribution(), dto.getShotsper(), dto.getKeypass(), dto.getPassprec(), dto.getDribbling(), dto.getFoulssub(), dto.getFoulscomm(), dto.getTackles(), dto.getTacklesper(), dto.getBreaks());
	}
}
