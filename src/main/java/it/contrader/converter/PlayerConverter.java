package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;


public class PlayerConverter {

	public static  PlayerDTO toTDO(Player player) {
		PlayerDTO playerDTO = null;
		if (player != null) {
			playerDTO = new PlayerDTO();
			
			playerDTO.setId(player.getId());
			playerDTO.setName(player.getName());
			playerDTO.setSurname(player.getSurname());
			playerDTO.setAge(player.getAge());
			playerDTO.setActualMarketValue(player.getActualMarketValue());
			playerDTO.setPreviousMarketValue(player.getPreviousMarketValue());
		
			playerDTO.setPosition(player.getPosition());
			
			
		}
		return playerDTO;
	}
	
	public static Player toEntity(PlayerDTO playerDTO) {
		
		return new Player(playerDTO.getId(), playerDTO.getName(), playerDTO.getSurname(), playerDTO.getAge(), playerDTO.getActualMarketValue(), playerDTO.getPreviousMarketValue(),
				playerDTO.getPosition());
	}
	public static List<PlayerDTO>  toListDTO(List<Player> list){
		List<PlayerDTO> listPlayerDTOs= new ArrayList<PlayerDTO>();
		if(!list.isEmpty()) {
			for(Player player:list) {
				listPlayerDTOs.add(PlayerConverter.toTDO(player));
			}
		}
		return listPlayerDTOs;
	}
	
	public static List<Player> toListEntity(List<PlayerDTO> listPlayerDTO) {
		List<Player> list = new ArrayList<>();
		if (!listPlayerDTO.isEmpty()) {
			for (PlayerDTO playerDTO : listPlayerDTO) {
				list.add(PlayerConverter.toEntity(playerDTO));
			}
		}
		return list;
	}
}
