package it.contrader.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import it.contrader.model.Team;

import it.contrader.utils.ConnectionSingleton;

public class TeamDAO implements DAO<Team>{

	private final String QUERY_ALL = "SELECT * FROM tb_teams";
	private final String QUERY_CREATE = "INSERT INTO tb_teams (name, market_value, `index`) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM tb_teams WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE tb_teams SET name=?, market_value=?, `index`=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM tb_teams WHERE id=?";
	
	public TeamDAO() {
		
	}

	@Override
	public List<Team> getAll() {
		Connection connection = ConnectionSingleton.getInstance();
		List<Team> teamList = new ArrayList<Team>();
		
		try {
			Team team;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				
				int id= resultSet.getInt("id");
				String name = resultSet.getString("name");
				int market_value = resultSet.getInt("market_value");
				int index = resultSet.getInt("index");
				team = new Team (id, name, market_value, index);
				teamList.add(team);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teamList;
		
	}

	@Override
	public Team read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		Team team;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int market_value = resultSet.getInt("market_value");
			int index = resultSet.getInt("index");
			String name = resultSet.getString("name");
			
			team=new Team(id, name, market_value, index);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return team;
	}

	@Override
	public boolean insert(Team teamToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, teamToInsert.getName());
			preparedStatement.setInt(2, teamToInsert.getMarketValue());
			preparedStatement.setInt(3, teamToInsert.getIndex());
			System.out.println(preparedStatement);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	}

	@Override
	public boolean update(Team teamToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (teamToUpdate.getId() == 0)
			return false;

		Team teamRead = read(teamToUpdate.getId());
		if (!teamRead.equals(teamToUpdate)) {
			try {
				// Fill the teamToUpdate object
				if (teamToUpdate.getName() == null || teamToUpdate.getName().equals("")) {
					teamToUpdate.setName(teamRead.getName());
				}

				if (teamToUpdate.getMarketValue() == 0) {
					teamToUpdate.setMarketValue(teamRead.getMarketValue());
				}

				if (teamToUpdate.getIndex() == 0) {
					teamToUpdate.setIndex(teamRead.getIndex());
				}

				// Update the team
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, teamToUpdate.getName());
				preparedStatement.setInt(2, teamToUpdate.getMarketValue());
				preparedStatement.setInt(3, teamToUpdate.getIndex());
				preparedStatement.setInt(4, teamToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
	
}
