package it.contrader.dto;

public class PlayerDTO implements DTO {

	
	private int player_id;
	private String player_name;
	private String player_surname;
	private int age;
	private int actualMarketValue;
	private int previousMarketValue;
	private String position;
	private String team;
	
	public PlayerDTO(int id, String name, String surname, int age, int actualMarketValue, int previousMarketValue, String position, String team ) {
		
		this.player_id = id;
		this.player_name = name;
		this.player_surname=surname;
		this.age = age;
		this.actualMarketValue = actualMarketValue;
		this.previousMarketValue = previousMarketValue;
		this.position = position;
		this.team = team;
		
	}
	public PlayerDTO(String player_name, String player_surname, int age, int actualMarketValue, int previousMarketValue,
			String position, String team) {
		super();
		this.player_name = player_name;
		this.player_surname = player_surname;
		this.age = age;
		this.actualMarketValue = actualMarketValue;
		this.previousMarketValue = previousMarketValue;
		this.position = position;
		this.team = team;
	}
	public PlayerDTO(int player_id, String player_name, String player_surname) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.player_surname = player_surname;
	}
	public PlayerDTO() {
		super();
	}
	public int getId() {
		return player_id;
	}
	public void setId(int id) {
		this.player_id = id;
	}
	public String getName() {
		return player_name;
	}
	public void setName(String name) {
		this.player_name = name;
	}
	
	
	public String getSurname() {
		return player_surname;
	
	}
	public void setSurname(String surname) {
		this.player_surname=surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getActualMarketValue() {
		return actualMarketValue;
	}
	public void setActualMarketValue(int actualMarketValue) {
		this.actualMarketValue = actualMarketValue;
	}
	public int getPreviousMarketValue() {
		return previousMarketValue;
	}
	public void setPreviousMarketValue(int previousMarketValue) {
		this.previousMarketValue = previousMarketValue;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + ", player_surname=" + player_surname
				+ ", age=" + age + ", actualMarketValue=" + actualMarketValue + ", previousMarketValue="
				+ previousMarketValue  + ", position=" + position 
				+  "]";
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	
}

