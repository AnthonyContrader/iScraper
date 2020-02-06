package it.contrader.model;

public class Player {

	
	private int player_id;
	private String player_name;
	private String player_surname;
	private int age;
	private int actualMarketValue;
	private int previousMarketValue;
	private String position;
	
	
	public Player(String player_name, String player_surname, int age, int actualMarketValue, int previousMarketValue,
			String position) {
		super();
		this.player_name = player_name;
		this.player_surname = player_surname;
		this.age = age;
		this.actualMarketValue = actualMarketValue;
		this.previousMarketValue = previousMarketValue;
		this.position = position;
	}
	public Player(int id, String name, String surname, int age, int actualMarketValue, int previousMarketValue,
			 String position) {
		
		this.player_id = id;
		this.player_name = name;
		this.player_surname=surname;
		this.age = age;
		this.actualMarketValue = actualMarketValue;
		this.previousMarketValue = previousMarketValue;
		this.position = position;
		
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
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	@Override
	public String toString() {
		//System.out.println();
		
//		"    " + player_id + "               " + player_name + "       " + player_surname
//		+ "           " + age + "           " + "         " + actualMarketValue + "                            "
//		+ previousMarketValue  + "                   " + position 
//		 ;
		
		return  "    " + player_id + "               " + player_name + "       " + player_surname
				+ "           " + age + "           " + "         " + actualMarketValue + "                            "
				+ previousMarketValue  + "                   " + position 
				 ;
	}
	
	
}
