package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Search;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {
	
	private final String QUERY_ALL = "SELECT * FROM tb_searches";
	private final String QUERY_CREATE = "INSERT INTO tb_searches (search_date, player_value, player_index, user, playerId) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM tb_searches WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE tb_searches SET search_date=?. player_value=?, player_index=?, user=?, playerId=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM tb_searches WHERE id=?";
	
	public SearchDAO(){}
	
	public List<Search> getAll() {
		List<Search> searchesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Search search;
			while (resultSet.next()) {
				long search_id = resultSet.getInt("id");
				Date search_date = resultSet.getDate("search_date");
				int value = resultSet.getInt("player_value");
				int index = resultSet.getInt("player_index");
				int user = resultSet.getInt("user");
				short player = resultSet.getShort("playerId");
				search = new Search(search_date, value, index, user, player);
				search.setID(search_id);
				searchesList.add(search);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchesList;
	}
	
	public boolean insert(Search searchToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setDate(1, searchToInsert.getDate());
			preparedStatement.setInt(2, searchToInsert.getValue());
			preparedStatement.setInt(3, searchToInsert.getIndex());
			preparedStatement.setInt(4, searchToInsert.getUser());
			preparedStatement.setShort(5, searchToInsert.getPlayer());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Search read(long id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Date search_date = resultSet.getDate("search_date");
			int value = resultSet.getInt("player_value");
			int index = resultSet.getInt("player_index");
			int user = resultSet.getInt("user");
			short player = resultSet.getShort("playerId");
			Search search = new Search(search_date, value, index, user, player);
			search.setID(resultSet.getLong("id"));
			return search;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(Search searchToUpdate) {
		System.out.println("fefe");
		Connection connection = ConnectionSingleton.getInstance();
		if (searchToUpdate.getID()==0) return false;
		Search searchRead = read(searchToUpdate.getID());
		System.out.println("fefe");
		if (!searchRead.equals(searchToUpdate)) {
			try {
				if (searchToUpdate.getDate() == null) {
					searchToUpdate.setDate(searchRead.getDate());
				}
				if (searchToUpdate.getValue() == 0) {
					searchToUpdate.setValue(searchRead.getValue());
				}
				if (searchToUpdate.getIndex() == 0) {
					searchToUpdate.setIndex(searchRead.getIndex());
				}
				if (searchToUpdate.getUser() == 0) {
					searchToUpdate.setUser(searchRead.getUser());
				}
				if (searchToUpdate.getPlayer() == 0) {
					searchToUpdate.setPlayer(searchRead.getPlayer());
				}
				//perch� qui il casting?
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setDate(1, searchToUpdate.getDate());
				preparedStatement.setInt(2, searchToUpdate.getValue());
				preparedStatement.setInt(3, searchToUpdate.getIndex());
				preparedStatement.setInt(4, searchToUpdate.getUser());
				preparedStatement.setShort(5, searchToUpdate.getPlayer());
				preparedStatement.setLong (6, searchToUpdate.getID());
				int a = preparedStatement.executeUpdate();
				if (a < 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				return false;
			}
		} else return false;
	}
	
	public boolean delete(long id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setLong(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0) return true;
		} catch (SQLException e) {}
		return false;
	}
	
}
