package it.contrader.service;

import it.contrader.converter.InjuryConverter;
import it.contrader.dao.InjuryDAO;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;
import it.contrader.model.Player;

import java.util.List;

public class InjuryService extends AbstractService<Injury, InjuryDTO> {
	
	private InjuryDAO injuryDAO;
	private InjuryConverter injuryConverter;
	
	public InjuryService() {
		this.injuryDAO = new InjuryDAO();
		this.injuryConverter = new InjuryConverter();
	}
}
