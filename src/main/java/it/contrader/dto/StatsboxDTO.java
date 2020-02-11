package it.contrader.dto;


import it.contrader.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StatsboxDTO {
	private long id;
	private Player player;
	private int season;
	private int caps;
	private float contributions;
	private float shotsper;
	private float keypass; 
	private float passprec;
	private float dribbling;
	private float foulssub; 
	private float foulscomm;
	private float tackles; 
	private float tacklesper; 
	private float breaks; 
}
