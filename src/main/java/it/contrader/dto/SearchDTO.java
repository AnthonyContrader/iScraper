package it.contrader.dto;

import java.sql.Date;

import it.contrader.model.User;
import it.contrader.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchDTO {

	private long id;
	
	private Date search_date;
	
	private int value;
	
	private int player_index;
	
	private User user;
	
	private Player player;
	
}