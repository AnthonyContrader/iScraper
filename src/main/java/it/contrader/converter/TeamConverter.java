package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import it.contrader.dto.TeamDTO;

import it.contrader.model.Team;

@Component
public class TeamConverter extends AbstractConverter<Team, TeamDTO>{
	
	@Override
	public Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team(teamDTO.getId(), teamDTO.getMarket_value(),  teamDTO.getName(),teamDTO.getTeam_index());
		}
		return team;
	}

	@Override
	public TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO(team.getId(), team.getName(), team.getMarket_value(), team.getTeam_index());
			
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
