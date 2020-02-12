package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StatsboxDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Statsbox;
import it.contrader.model.Team;


public class TeamConverter extends AbstractConverter<Team, TeamDTO>{
	
	@Override
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team(teamDTO.getId(), teamDTO.getName(), teamDTO.getMarketValue(), teamDTO.getTeamIndex());
		}
		return team;
	}

	@Override
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO(team.getId(), team.getName(), team.getMarketValue(), team.getTeamIndex());
		}
		return teamDTO;
	}
	
	public List<TeamDTO> toListDTO(List<Team> list) {
		List<TeamDTO> DTOlist = new ArrayList<TeamDTO>();
		for (Team t: list) {
			DTOlist.add(this.toDTO(t));
		}
		return DTOlist;
	}

}
