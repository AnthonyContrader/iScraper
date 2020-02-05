package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

public class TeamConverter implements Converter<Team, TeamDTO>{

	@Override
	public TeamDTO toDTO(Team team) {
		return new TeamDTO(team.getId(), team.getName(), team.getMarketValue(), team.getIndex());
	}

	@Override
	public Team toEntity(TeamDTO dto) {
		return new Team(dto.getId(), dto.getName(), dto.getMarketValue(), dto.getIndex());
	}

	@Override
	public List<TeamDTO> toDTOList(List<Team> teamList) {
		List<TeamDTO> DTOList = new ArrayList<TeamDTO>();
		for (Team t : teamList) {
			DTOList.add(toDTO(t));
		}
		return DTOList;
	}
	
}
