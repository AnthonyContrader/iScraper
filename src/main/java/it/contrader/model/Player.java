package it.contrader.model;

public class Player {

	
	private int player_id;
	private String player_name;
	private String player_surname;
	private int age;
	private int actualMarketValue;
	private int previousMarketValue;
	private int accidents;
	private String position;
	private int goals;
	private int minutesPlayed;
	public Player(int id, String name, String surname, int age, int actualMarketValue, int previousMarketValue,
			int accidents, String position, int goals, int minutesPlayed) {
		super();
		this.player_id = id;
		this.player_name = name;
		this.player_surname=surname;
		this.age = age;
		this.actualMarketValue = actualMarketValue;
		this.previousMarketValue = previousMarketValue;
		this.accidents = accidents;
		this.position = position;
		this.goals = goals;
		this.minutesPlayed = minutesPlayed;
	}
	public Player(int player_id, String player_name, String player_surname) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.player_surname = player_surname;
	}
	public Player() {
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
	public int getAccidents() {
		return accidents;
	}
	public void setAccidents(int accidents) {
		this.accidents = accidents;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getMinutesPlayed() {
		return minutesPlayed;
	}
	public void setMinutesPlayed(int minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}
	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", player_name=" + player_name + ", player_surname=" + player_surname
				+ ", age=" + age + ", actualMarketValue=" + actualMarketValue + ", previousMarketValue="
				+ previousMarketValue + ", accidents=" + accidents + ", position=" + position + ", goals=" + goals
				+ ", minutesPlayed=" + minutesPlayed + "]";
	}
	
	
}
