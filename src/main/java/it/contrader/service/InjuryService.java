package it.contrader.service;

import it.contrader.converter.InjuryConverter;
import it.contrader.dao.InjuryDAO;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;
import it.contrader.model.Player;

import java.util.List;

public class InjuryService {
	
	private InjuryDAO injuryDAO;
	private InjuryConverter injuryConverter;
	
	public InjuryService() {
		this.injuryDAO = new InjuryDAO();
		this.injuryConverter = new InjuryConverter();
	}
	public List<Injury> getAllInjuries(){
		return this.injuryDAO.getAllInjury();
	}
	public List<InjuryDTO> getAll() {
		return injuryConverter.toDTOList(injuryDAO.getAllInjury());
	}
	
	public Injury readInjury(int player_id) {
		return this.injuryDAO.read(player_id);
		
	}
	public InjuryDTO read(int player_id) {
		return injuryConverter.toDTO(injuryDAO.read(player_id));
	}
	
	public boolean insert (InjuryDTO dto) {
		return injuryDAO.insert(injuryConverter.toEntity(dto));
	}
	
	public boolean update (InjuryDTO dto) {
		return injuryDAO.update(injuryConverter.toEntity(dto));
	}
	
	public boolean delete (int id) {
		return injuryDAO.delete(id);
	}

}
