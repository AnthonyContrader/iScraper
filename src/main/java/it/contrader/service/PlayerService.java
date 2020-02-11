package it.contrader.service;


import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.contrader.converter.PlayerConverter;
import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;

import it.contrader.model.Player;

import it.contrader.model.User;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Data
@Entity

@Service
public class PlayerService extends AbstractService<Player, PlayerDTO>{

	
	private PlayerConverter playerConverter;
	private final PlayerRepository playerRepository;
	
	@Autowired
	public  PlayerService(PlayerRepository playerRepository) {
		
		this.playerRepository=playerRepository;
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertPlayer(PlayerDTO playerDTO) {
		return playerRepository.save(playerConverter.toEntity(playerDTO)) != null;
	}
	

	
	public boolean updatePlayer(PlayerDTO playerDTO) {
		return playerRepository.save(playerConverter.toEntity(playerDTO)) != null;
	}
	
	public void deletePlayerById(int id) {
		playerRepository.deleteById(id);
	}
	
	public List<PlayerDTO> getListPlayerDTO(){
		List<Player> listPlayer = (List<Player>) playerRepository.findAll();
		List<PlayerDTO> listPlayerDTO = playerConverter.toDTOList(listPlayer);
		return listPlayerDTO;

	}
	
	
	
	public PlayerDTO getPlayerDTObyId(int id) {
		Player player = playerRepository.read(id);
		PlayerDTO playerDTO = playerConverter.toDTO(player);
		return playerDTO;
	}
	
	
	
	
	
	

	
	
	
}
