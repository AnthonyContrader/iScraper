package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class PlayerDTO {
	private int id;
	private String player_name;
	private String player_surname;
	private int age;
	private int actualMarketValue;
	private int previousMarketValue;
	private String position;
	private String team;
	
}