package it.contrader.model;

public class Statsbox {
	private String playerId;
	private String season;
	private String team;
	private int caps; //questo campo indica le presenze in questa stagione in campionato
	private float contribution; //questo campo indica le contribuzioni (gol o assist, che valgono rispettivamente 1 e 0.5) per 90 minuti di quel giocatore
	private float shots; //questo campo indica la percentuale di tiri in porta su tiri totali del giocatore, su 90 minuti
	private float keypass; //questo campo indica i passaggi chiave effettuati, su 90 minuti
	private float passprec; //questo campo indica la precisione dei passaggi (passaggi riusciti/passaggi effettuati)
	private float dribbling; //questo campo indica il numero di dribbling riusciti per partita
	private float foulssub; //falli subiti a partita
	private float foulscomm; //falli fatti a partita
	private float tackles; //contrasti effettuati a partita
	private float tacklesper; //percentuale di contrasti riusciti a partita
	private float breaks; //numero di interruzioni del possesso avversario (palla recuperata, salvataggi, palla spazzata) a partita
	
	public Statsbox() {
		
	}
	
	public Statsbox(String playerId, String season, String team, int caps, float contribution, float shots,
			float keypass, float passprec, float dribbling, float foulssub, float foulscomm, float tackles,
			float tacklesper, float breaks) {
		super();
		this.playerId = playerId;
		this.season = season;
		this.team = team;
		this.caps = caps;
		this.contribution = contribution;
		this.shots = shots;
		this.keypass = keypass;
		this.passprec = passprec;
		this.dribbling = dribbling;
		this.foulssub = foulssub;
		this.foulscomm = foulscomm;
		this.tackles = tackles;
		this.tacklesper = tacklesper;
		this.breaks = breaks;
	}
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getCaps() {
		return caps;
	}
	public void setCaps(int caps) {
		this.caps = caps;
	}
	public float getContribution() {
		return contribution;
	}
	public void setContribution(float contribution) {
		this.contribution = contribution;
	}
	public float getShots() {
		return shots;
	}
	public void setShots(float shots) {
		this.shots = shots;
	}
	public float getKeypass() {
		return keypass;
	}
	public void setKeypass(float keypass) {
		this.keypass = keypass;
	}
	public float getPassprec() {
		return passprec;
	}
	public void setPassprec(float passprec) {
		this.passprec = passprec;
	}
	public float getDribbling() {
		return dribbling;
	}
	public void setDribbling(float dribbling) {
		this.dribbling = dribbling;
	}
	public float getFoulssub() {
		return foulssub;
	}
	public void setFoulssub(float foulssub) {
		this.foulssub = foulssub;
	}
	public float getFoulscomm() {
		return foulscomm;
	}
	public void setFoulscomm(float foulscomm) {
		this.foulscomm = foulscomm;
	}
	public float getTackles() {
		return tackles;
	}
	public void setTackles(float tackles) {
		this.tackles = tackles;
	}
	public float getTacklesper() {
		return tacklesper;
	}
	public void setTacklesper(float tacklesper) {
		this.tacklesper = tacklesper;
	}
	public float getBreaks() {
		return breaks;
	}
	public void setBreaks(float breaks) {
		this.breaks = breaks;
	}
	
	
}
