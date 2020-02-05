package it.contrader.service;

import java.util.List;

import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerDAO;
import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;

public class PlayerService extends AbstractService<Player, PlayerDTO>{

	private PlayerDAO playerDAO;
	private PlayerConverter playerConverter;
	public PlayerService() {
		this.dao= new PlayerDAO();
		this.converter=new PlayerConverter();
//	}
//	
//	public List<Player> getAllPlayers(){
//		return this.playerDAO.getAll();
//	}
//	
////	public boolean insertPlayer(PlayerDTO dto) {
////		return this.playerDAO.(dto);
////	}
//	public boolean insert (PlayerDTO dto) {
//		return playerDAO.insert(playerConverter.toEntity(dto));
//	}
//	
//	
//	public Player readPlayer(int player_id) {
//		return this.playerDAO.read(player_id);
//		
//	}
//	
//	public boolean updatePlayer(PlayerDTO playerDTO) {
//		return this.playerDAO.update(playerConverter.toEntity(playerDTO));
//	}
//	public boolean deletePlayer(int id) {
//		return this.playerDAO.delete(id);
//	}
//	public List<PlayerDTO> getAll() {
//		return playerConverter.toDTOList(playerDAO.getAll());
//	}
//	
//	public PlayerDTO read(int playerId) {
//		return playerConverter.toDTO((playerDAO.read(playerId)));
//	}
}
}