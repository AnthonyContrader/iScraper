package it.contrader.service;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.StatsboxDTO;
import it.contrader.model.Player;

import java.util.List;

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
	
//	public boolean insertPlayer(PlayerDTO dto) {
//		return this.playerDAO.(dto);
//	}
	public boolean insert (PlayerDTO dto) {
		return playerDAO.insertPlayer(playerConverter.toEntity(dto));
	}
	
	
	public Player readPlayer(int player_id) {
		return this.playerDAO.readPlayer(player_id);
		
	}
	
	public boolean updatePlayer(PlayerDTO playerDTO) {
		return this.playerDAO.updatePlayer(playerConverter.toEntity(playerDTO));
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
