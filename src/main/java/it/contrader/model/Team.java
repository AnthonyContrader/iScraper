package it.contrader.model;

public class Team {
	private int id;
	private String name;
	private int marketValue;
	private int teamIndex;
	
	public Team(int id, String name, int marketValue, int teamIndex) {
		super();
		this.id = id;
		this.name = name;
		this.marketValue = marketValue;
		this.teamIndex = teamIndex;
	}
	
	public Team( String name, int marketValue, int teamIndex) {
		super();
		this.name = name;
		this.marketValue = marketValue;
		this.teamIndex = teamIndex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}

	public int getIndex() {
		return teamIndex;
	}

	public void setIndex(int teamIndex) {
		this.teamIndex = teamIndex;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + marketValue + "\t" + teamIndex;
	}
	
}
