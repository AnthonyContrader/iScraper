package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.PlayerDTO;

import it.contrader.model.Player;


@Component
public class PlayerConverter extends AbstractConverter<Player, PlayerDTO>{

	@Override
	public Player toEntity(PlayerDTO dto) {
		// TODO Auto-generated method stub
		Player player=null;
		if(dto!=null) {
			player= new Player(dto.getId(),dto.getTeam(),dto.getPlayer_name(), dto.getPlayer_surname(),dto.getAge(),dto.getActualMarketValue(),dto.getPreviousMarketValue(), dto.getPosition(),dto.getTeam_id());}
		
		

		return player;
	}

	@Override
	public PlayerDTO toDTO(Player entity) {
		// TODO Auto-generated method stub
		
		PlayerDTO playerDTO=null;
		if(entity!=null) {
			playerDTO=new PlayerDTO(entity.getId(),entity.getTeam(), entity.getPlayer_name(), entity.getPlayer_surname(), entity.getAge(), entity.getActualMarketValue(), entity.getPreviousMarketValue(), entity.getPosition(), entity.getTeam_id());}
		return playerDTO;
	}
	public List<PlayerDTO> toListDTO(List<Player> list) {
		List<PlayerDTO> DTOlist = new ArrayList<PlayerDTO>();
		for (Player s: list) {
			DTOlist.add(this.toDTO(s));
		}
		return DTOlist;
	}

}
