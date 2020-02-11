package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_players")

public class Player {
		
	@Id
	@Column(name="id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="player_name")
	@NotNull
	private String player_name;
	
	@Column(name ="player_surname")
	@NotNull
	private String player_surname;
	
	@Column(name ="age")
	@NotNull
	private int age;
	
	@Column(name ="actual_value")
	@NotNull
	private int actual_value;

	@Column(name ="previous_value")
	@NotNull
	private int previous_value;
	
	@Column(name ="position")
	@NotNull
	private String position;
	
	@Column(name="team")
	@NotNull
	private String team;
	
	
	
	
}