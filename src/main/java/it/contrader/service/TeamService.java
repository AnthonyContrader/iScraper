package it.contrader.service;

import it.contrader.converter.TeamConverter;
import it.contrader.dao.TeamDAO;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

public class TeamService extends AbstractService <Team, TeamDTO>{
	
	
	public TeamService () {
		this.dao = new TeamDAO();
		this.converter = new TeamConverter();
	}

	@Override
	public TeamDTO read(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
