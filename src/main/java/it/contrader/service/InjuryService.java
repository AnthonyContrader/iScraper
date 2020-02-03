package it.contrader.service;

import it.contrader.converter.InjuryConverter;
import it.contrader.dao.InjuryDAO;
import it.contrader.dto.InjuryDTO;
import it.contrader.model.Injury;


public class InjuryService extends AbstractService<Injury, InjuryDTO> {
	
	
	public InjuryService() {
		this.dao = new InjuryDAO();
		this.converter = new InjuryConverter();
	}
}
