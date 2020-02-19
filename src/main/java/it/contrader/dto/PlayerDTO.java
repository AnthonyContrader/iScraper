package it.contrader.dto;

import it.contrader.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor



public class PlayerDTO {
	
	private long id;
	
	private String player_name;
	private String player_surname;
	private int age;
	private int actualMarketValue;
	private int previousMarketValue;
	private String position;
	
	private Team team;
//	private int team_id;
	
	
}