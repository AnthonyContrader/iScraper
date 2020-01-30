package it.contrader.service;

import java.util.List;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.PlayerDTO;

import it.contrader.model.Player;

public class PlayerService {

	private PlayerDAO playerDAO;
	private PlayerConverter playerConverter;
	
	public PlayerService() {
		this.playerDAO= new PlayerDAO();
		this.playerConverter=new PlayerConverter();
	}
	
	public List<Player> getAllPlayers(){
		return this.playerDAO.getAllPlayers();
	}
	
	public boolean insertPlayer(Player player) {
		return this.playerDAO.insertPlayer(player);
	}
	
	public Player readPlayer(int player_id) {
		return this.playerDAO.readPlayer(player_id);
		
	}
	
	public boolean updatePlayer(Player player) {
		return this.playerDAO.updatePlayer(player);
	}
	public boolean deletePlayer(int id) {
		return this.playerDAO.deletePlayer(id);
	}
	public List<PlayerDTO> getAll() {
		return playerConverter.toListDTO(playerDAO.getAllPlayers());
	}
	
	public PlayerDTO read(int playerId) {
		return playerConverter.toTDO((playerDAO.readPlayer(playerId)));
	}
}
