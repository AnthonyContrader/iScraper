package it.contrader.model;

public class Injury {
	private int playerID;
	private String typology;
	private int duration;
	private int gravityIndex;
	private int season;
	
	public Injury(int id, String tp, int dur, int g_ind, int seas) {
		super();
		this.playerID=id;
		this.typology=tp;
		this.duration=dur;
		this.gravityIndex=g_ind;
		this.season=seas;
	}
	
	// -------------------------- //
	
	public int getPlayerID() { 
		return playerID; 
		}
	
	public void setPlayerID(int id) {
		this.playerID=id;
	}
	
	// -------------------------- //
	
	public String getTypology() {
		return typology;
	}
	
	public void setTypology(String tp) {
		this.typology=tp;
	}
	
	// -------------------------- //
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int dur) {
		this.duration=dur;
	}
	
	// -------------------------- //
	
	public int getGravityIndex() {
		return gravityIndex;
	}
	
	public void setGravityIndex(int g_index) {
		this.gravityIndex=g_index;
	}
	
	// -------------------------- //
	
	public int getSeason() {
		return season;
	}
	
	public void setSeason(int seas) {
		this.season=seas;
	}
	
	// -------------------------- //
	
	@Override
	public String toString() {
		return "Injury [playerID="+ playerID +", typology="+ typology +", duration="+ duration +", gravity_index="+ gravityIndex +", season="+ season +"]";
	}
}

