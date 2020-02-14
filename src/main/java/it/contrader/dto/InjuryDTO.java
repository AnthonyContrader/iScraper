package it.contrader.dto;

import it.contrader.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InjuryDTO {

	private long id;
	
	private int severity;
	
	private String description;
	
	private int duration;
	
	private String date;
	
	private Player player;
	
}
