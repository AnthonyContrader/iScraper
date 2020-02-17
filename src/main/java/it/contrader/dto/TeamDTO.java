package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TeamDTO {
	private long id;
	private String name;
	private int market_value;
	private int team_index;
}
