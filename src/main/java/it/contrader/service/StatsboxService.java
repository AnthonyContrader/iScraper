package it.contrader.service;

import it.contrader.converter.StatsboxConverter;
import it.contrader.dao.StatsboxDAO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Statsbox;

public class StatsboxService extends AbstractService<Statsbox, StatsboxDTO> {

	
	public StatsboxService() {
		this.dao = new StatsboxDAO();
		this.converter = new StatsboxConverter();
	}
}
