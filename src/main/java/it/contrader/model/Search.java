package it.contrader.model;

import java.sql.Date;

public class Search {
	
	private int search_id;

	private int value, index, user_id;
	private Date search_date;
	private short player;
	
	public Search() {}

	public Search(Date search_date, int value, int index, int user_id, short player) {
		this.search_date = search_date;
		this.value = value;
		this.index = index;
		this.user_id = user_id;
		this.player = player;
	}
	
	public Search(int search_id, Date search_date, int value, int index, int user_id, short player) {

		this.search_id = search_id;
		this.search_date = search_date;
		this.value = value;
		this.index = index;
		this.user_id = user_id;
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
	
	public int getUser() {
		return user_id;
	}
	
	public void setUser(int user_id) {
		this.user_id = user_id;
	}
	
	public short getPlayer() {
		return player;
	}
	
	public void setPlayer(short player) {
		this.player = player;
	}
	
	@Override
	public String toString() {
		return  search_id + "\t"  + search_date +"\t\t" +   value + "\t\t" + index + "\t\t" + user_id + "\t\t" + player + "\t\t";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Search other = (Search) obj;
		if (search_id != other.search_id)
			return false;
		if (search_date != other.search_date)
			return false;
		if (value != other.value)
			return false;
		if (index != other.index)
			return false;
		if (user_id != other.user_id)
			return false;
		if (player != other.player)
			return false;
		return true;
	}
}