package it.contrader.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;

import it.contrader.model.Player;
import it.contrader.model.Team;


@Service
public class PlayerService extends AbstractService<Player, PlayerDTO>{

	
	@Autowired
	private PlayerConverter playerConverter;
	@Autowired
	private PlayerRepository playerRepository;
	
	public List<PlayerDTO> findByTeam(Team team) {
		return playerConverter.toDTOList(playerRepository.findByTeam(team));
	}
	

}