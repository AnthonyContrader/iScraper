package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Statsbox {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
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
