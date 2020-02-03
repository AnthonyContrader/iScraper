package it.contrader.dto;

public class TeamDTO implements DTO{
	private int id;
	private String name;
	private int marketValue;
	private int teamIndex;
	
	public TeamDTO(int id, String name, int marketValue, int teamIndex) {
		super();
		this.id = id;
		this.name = name;
		this.marketValue = marketValue;
		this.teamIndex = teamIndex;
	}
	
	public TeamDTO( String name, int marketValue, int teamIndex) {
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

	public int getTeamIndex() {
		return teamIndex;
	}

	public void setTeamIndex(int teamIndex) {
		this.teamIndex = teamIndex;
	}
	
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + marketValue + "\t" + teamIndex;
	}
}
