package it.contrader.service;

import it.contrader.converter.StatsboxConverter;
import it.contrader.dao.StatsboxDAO;
import it.contrader.dto.StatsboxDTO;

import java.util.List;

public class StatsboxService {

	private StatsboxDAO statsboxDAO;
	private StatsboxConverter statsboxConverter;
	
	public StatsboxService() {
		this.statsboxDAO = new StatsboxDAO();
		this.statsboxConverter = new StatsboxConverter();
	}
	
	public List<StatsboxDTO> getAll() {
		return statsboxConverter.toDTOList(statsboxDAO.getAll());
	}
	
	public StatsboxDTO read(int playerId, int season) {
		return statsboxConverter.toDTO(statsboxDAO.read(playerId, season));
	}
	
	public boolean insert (StatsboxDTO dto) {
		return statsboxDAO.insert(statsboxConverter.toEntity(dto));
	}
	
	public boolean update (StatsboxDTO dto) {
		return statsboxDAO.update(statsboxConverter.toEntity(dto));
	}
	
	public boolean delete (int playerId, int season) {
		return statsboxDAO.delete(playerId, season);
	}
}
