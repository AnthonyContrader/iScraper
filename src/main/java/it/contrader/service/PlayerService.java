package it.contrader.service;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;

import it.contrader.model.Player;
import it.contrader.model.Team;

import lombok.AllArgsConstructor;


@AllArgsConstructor


//@Entity

@Service
public class PlayerService extends AbstractService<Player, PlayerDTO>{

	
	private PlayerConverter playerConverter;
	private final PlayerRepository playerRepository;
	
	@Autowired
	public  PlayerService(PlayerRepository playerRepository) {
		
		this.playerRepository=playerRepository;
		// TODO Auto-generated constructor stub
	}
	
	public List<PlayerDTO> findByTeam(Team team) {
		return playerConverter.toDTOList(playerRepository.findByTeam(team));
	}
	
	
	

	
	
	
}
