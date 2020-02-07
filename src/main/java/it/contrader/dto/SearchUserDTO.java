package it.contrader.dto;

import java.sql.Date;

public class SearchUserDTO implements DTO{
	
	private int search_id;
	private int value, index;
	private Date search_date;
	private short player;
	
	public SearchUserDTO() {}

	public SearchUserDTO(Date search_date, int value, int index, short player) {
		this.search_date = search_date;
		this.value = value;
		this.index = index;
		this.player = player;
	}
	
	public SearchUserDTO(int search_id, Date search_date, int value, int index, short player) {
		this.search_id = search_id;
		this.search_date = search_date;
		this.value = value;
		this.index = index;
		this.player = player;
	}
	
	public int getID() {
		return search_id;
	}
	
	public void setID(int search_id) {
		this.search_id = search_id;
	}
	
	public Date getDate() {
		return search_date;
	}
	
	public void setDate(Date search_date) {
		this.search_date = search_date;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public short getPlayer() {
		return player;
	}
	
	public void setPlayer(short player) {
		this.player = player;
	}
	
	@Override
	public String toString() {
		return  search_id + "\t"  + search_date +"\t\t" +   value + "\t\t" + index + "\t\t" + player + "\t\t";
	}
}