package it.contrader.dao;

import it.contrader.controller.GestoreEccezzioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Player;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class PlayerDAO {

	private final String QUERY_ALL = "select * from tb_players";
	

	private final String QUERY_INSERT = "insert into tb_players (id, player_name, player_surname, age, actual_value, previous_value, position) values (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from tb_players where id=?";

	private final String QUERY_UPDATE = "UPDATE tb_players SET player_name=?, player_surname=?, age=?, actual_value=?, previous_value=?, position=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE from tb_players WHERE id=?";
	
	
	
	public PlayerDAO() {
	}

	public List<Player> getAllPlayers() {
		List<Player> playerList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
	
			while (resultSet.next()) {

				
				Player player=new Player();
				
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("player_name"));
				player.setSurname(resultSet.getString("player_surname"));
				player.setAge(resultSet.getInt("age"));
				player.setActualMarketValue(resultSet.getInt("actual_value"));
				player.setPreviousMarketValue(resultSet.getInt("previous_value"));
				
				player.setPosition(resultSet.getString("position"));
				
				playerList.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}
	

	public boolean insertPlayer(Player player) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setString(3, player.getSurname());
			preparedStatement.setInt(4, player.getAge());
			preparedStatement.setInt(5, player.getActualMarketValue());
			preparedStatement.setInt(6, player.getPreviousMarketValue());
			
			preparedStatement.setString(7, player.getPosition());
	
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezzioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Player readPlayer(int player_id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, player_id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Player player=new Player();
			try {
				player.setId(resultSet.getInt("id"));
				player.setName(resultSet.getString("player_name"));
				player.setSurname(resultSet.getString("player_surname"));
				player.setAge(resultSet.getInt("age"));
				player.setActualMarketValue(resultSet.getInt("actual_value"));
				player.setActualMarketValue(resultSet.getInt("previous_value"));
				player.setPosition(resultSet.getString("position"));
			} catch (Exception e) {
				// TODO: handle exception
			//	GestoreEccezzioni.getInstance().gestisciEccezione(e);
			}
			
	
			
			return player;
		} catch (SQLException e) {
			GestoreEccezzioni.getInstance().gestisciEccezione(e);
			return null;
		}
		

	}

	public boolean updatePlayer(Player player) {
		Connection connection = ConnectionSingleton.getInstance();
		if (player.getId() == 0)
			return false;

		
		Player playerRead = readPlayer(player.getId());
		System.out.println(player);
		if(!playerRead.equals(player)) {
			try {
			if (player.getName() == null || player.getName().equals("")) {
				player.setName(playerRead.getName());
			}

			if (player.getSurname() == null || player.getSurname().equals("")) {
				player.setSurname(playerRead.getSurname());
			}

			if (player.getAge() == 0) {
				player.setAge(playerRead.getAge());
			}
			
			if (player.getActualMarketValue()== 0) {
				player.setActualMarketValue(playerRead.getActualMarketValue());
			}
			
			if (player.getPreviousMarketValue()== 0) {
				player.setPreviousMarketValue(playerRead.getPreviousMarketValue());
			}
			
			if (player.getPosition() == null || player.getPosition().equals("")) {
				player.setPosition(playerRead.getPosition());
			}
			
			
			PreparedStatement preparedStatement =(PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, player.getId());
			preparedStatement.setString(2, player.getName());
			preparedStatement.setString(3, player.getSurname());
			preparedStatement.setInt(4, player.getAge());
			preparedStatement.setInt(5, player.getActualMarketValue());
			preparedStatement.setInt(6, player.getPreviousMarketValue());
			
			preparedStatement.setString(7, player.getPosition());
	
			int a = preparedStatement.executeUpdate();
			if (a > 0) 
				
				return true;
			else
				
				return false;

		} catch (SQLException e) {
			
		//	System.out.println("error");
			return false;
		}
	}

	return false;

}

	
	
	public boolean deletePlayer(Integer id) {
			Connection connection = ConnectionSingleton.getInstance();
			
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
				preparedStatement.setInt(1, id);
				int n = preparedStatement.executeUpdate();
				if (n != 0)
					System.out.println("Player removed");
					return true;
			} catch (SQLException e) {
			System.out.println(e.getMessage());
			}
			return false;
		

	}
	}
