package it.contrader.service;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;

public class PlayerService extends AbstractService<Player, PlayerDTO>{

	
	public PlayerService() {
		this.dao= new PlayerDAO();
		this.converter=new PlayerConverter();
	}
}
