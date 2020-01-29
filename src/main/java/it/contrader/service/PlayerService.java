package it.contrader.service;

import java.util.List;

import it.contrader.dao.PlayerDAO;
import it.contrader.model.Player;

public class PlayerService {

	private PlayerDAO playerDAO;

	public PlayerService() {
		this.playerDAO= new PlayerDAO();
		
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
	public boolean deletePlayer(Integer id) {
		return this.playerDAO.deletePlayer(id);
	}
}
