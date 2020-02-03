package it.contrader.service;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Player;

import java.util.List;

public class PlayerService extends AbstractService<Player, PlayerDTO>{

	private PlayerDAO playerDAO;
	private PlayerConverter playerConverter;
	
	public PlayerService() {
		this.playerDAO= new PlayerDAO();
		this.playerConverter=new PlayerConverter();
	}
}
