package it.contrader.converter;

import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;

import java.util.ArrayList;
import java.util.List;


public class PlayerConverter implements Converter<Player, PlayerDTO>{

	
	public PlayerConverter() {
		
	}


	public   PlayerDTO toDTO(Player player) {

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
			playerDTO.setTeam(player.getTeam());

			
			
		}
		return playerDTO;
	}
	
	public  Player toEntity(PlayerDTO playerDTO) {
		
		return new Player(playerDTO.getId(), playerDTO.getName(), playerDTO.getSurname(), playerDTO.getAge(), playerDTO.getActualMarketValue(), playerDTO.getPreviousMarketValue(),
				playerDTO.getPosition(), playerDTO.getTeam());

	}
	
	
	

	public  List<PlayerDTO>  toDTOList(List<Player> list){

		List<PlayerDTO> listPlayerDTOs= new ArrayList<PlayerDTO>();
		
			for(Player player:list) {
				
				listPlayerDTOs.add(this.toDTO(player));

			}
		
		return listPlayerDTOs;
	}
	
//	public  List<Player> toListEntity(List<PlayerDTO> listPlayerDTO) {
//		List<Player> list = new ArrayList<>();
//		if (!listPlayerDTO.isEmpty()) {
//			for (PlayerDTO playerDTO : listPlayerDTO) {
//				list.add(PlayerConverter.toEntity(playerDTO));
//			}
//		}
//		return list;
//	}
}
