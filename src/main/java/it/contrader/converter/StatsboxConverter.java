package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Statsbox;

@Component
public class StatsboxConverter extends AbstractConverter<Statsbox, StatsboxDTO> {

	@Override
	public Statsbox toEntity(StatsboxDTO dto) {
		Statsbox statsbox = new Statsbox (dto.getId(), dto.getPlayer(), dto.getSeason(), dto.getCaps(), dto.getContributions(), dto.getShotsper(), dto.getKeypass(), dto.getPassprec(), dto.getDribbling(), dto.getFoulscomm(), dto.getFoulssub(), dto.getTackles(), dto.getTacklesper(), dto.getBreaks());
		return statsbox;
	}

	@Override
	public StatsboxDTO toDTO(Statsbox entity) {
		StatsboxDTO statsboxDTO = new StatsboxDTO (entity.getId(), entity.getPlayer(), entity.getSeason(), entity.getCaps(), entity.getContributions(), entity.getShotsper(), entity.getKeypass(), entity.getPassprec(), entity.getDribbling(), entity.getFoulscomm(), entity.getFoulssub(), entity.getTackles(), entity.getTacklesper(), entity.getBreaks());
		return statsboxDTO;
	}
	
	public List<StatsboxDTO> toListDTO(List<Statsbox> list) {
		List<StatsboxDTO> DTOlist = new ArrayList<StatsboxDTO>();
		for (Statsbox s: list) {
			DTOlist.add(this.toDTO(s));
		}
		return DTOlist;
	}
	
	}
