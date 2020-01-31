package it.contrader.service;

import it.contrader.converter.InjuryConverter;
import it.contrader.dao.InjuryDAO;
import it.contrader.dto.InjuryDTO;

import java.util.List;

public class InjuryService {
	
	private InjuryDAO injuryDAO;
	private InjuryConverter injuryConverter;
	
	public InjuryService() {
		this.injuryDAO = new InjuryDAO();
		this.injuryConverter = new InjuryConverter();
	}
	
	public List<InjuryDTO> getAll() {
		return injuryConverter.toDTOList(injuryDAO.getAllInjury());
	}
	
	public InjuryDTO read(int playerID, int season) {
		return injuryConverter.toDTO(injuryDAO.read(playerID, season));
	}
	
	public boolean insert (InjuryDTO dto) {
		return injuryDAO.insert(injuryConverter.toEntity(dto));
	}
	
	public boolean update (InjuryDTO dto) {
		return injuryDAO.update(injuryConverter.toEntity(dto));
	}
	
	public boolean delete (int playerID,int season) {
		return injuryDAO.delete(playerID, season);
	}

}
