package it.contrader.converter;

import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Player;
import it.contrader.model.User;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PlayerConverter extends AbstractConverter<Player, PlayerDTO>{

	@Override
	public Player toEntity(PlayerDTO dto) {
		// TODO Auto-generated method stub
		Player player=null;
		if(dto!=null) {
			player= new Player(dto.getId(),dto.getPlayer_name(), dto.getPlayer_surname(),dto.getAge(),dto.getActualMarketValue(),dto.getPreviousMarketValue(), dto.getPosition(),dto.getTeam());}
		
		

		return player;
	}

	@Override
	public PlayerDTO toDTO(Player entity) {
		// TODO Auto-generated method stub
		
		PlayerDTO playerDTO=null;
		if(entity!=null) {
			playerDTO=new PlayerDTO(entity.getId(), entity.getPlayer_name(), entity.getPlayer_surname(), entity.getAge(), entity.getActualMarketValue(), entity.getPreviousMarketValue(), entity.getPosition(), 
					entity.getTeam());
		}
		return playerDTO;
	}

}
