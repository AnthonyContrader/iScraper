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
	
	public InjuryDTO read(int id) {
		return injuryConverter.toDTO(injuryDAO.read(id));
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
