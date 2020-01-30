package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Injury;

public class InjuryDAO {
	
	private final String QUERY_ALL = "SELECT * FROM Injury";
	private final String QUERY_CREATE = "INSERT into Injury (playerName, typology, duration, gravityIndex, season) values (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM Injury WHERE playerID=?";
	private final String QUERY_UPDATE= "UPDATE Injury SET typology=?, duration=?, gravityIndex=?, season=? WHERE playerName=?";
	private final String QUERY_DELETE= "DELETE FROM Indury WHERE playerName=?";

	public InjuryDAO() {}
	
	public List<Injury> getAllInjury() {
			List<Injury> injuryList=new ArrayList<>();
			Connection connection = ConnectionSingleton.getInstance();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				Injury injury;
				while (resultSet.next()) {
					int playerID = resultSet.getInt("playerID");
					String typology = resultSet.getString("typology");
					int duration = resultSet.getInt("duration");
					int gravityIndex = resultSet.getInt("gravityIndex");
					int season = resultSet.getInt("season");
					
					injury = new Injury(playerID, typology, duration, gravityIndex, season);
					injuryList.add(injury);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return injuryList;
	}
	
	public boolean insert(Injury injuryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1,injuryToUpdate.getPlayerID());
			preparedStatement.setString(2,injuryToUpdate.getTypology());
			preparedStatement.setInt(3,injuryToUpdate.getDuration());
			preparedStatement.setInt(4,injuryToUpdate.getGravityIndex());
			preparedStatement.setInt(5,injuryToUpdate.getSeason());
			return true;
		} catch(SQLException e) {
			return false;
		}
	}
	
	public Injury read(int playerID,int season) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1,playerID);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String typology = resultSet.getString("typology");
			int duration = resultSet.getInt("duration");
			int gravityIndex = resultSet.getInt("gravityIndex");
			
			Injury injury = new Injury(playerID, typology, duration, gravityIndex, season);
			
			return injury;
		} catch(SQLException e) {
			return null;
		}
	}
	
	public boolean delete(int playerID, int season) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, playerID);
			preparedStatement.setInt(2, season);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {	
		}
		return false;
	}
	
	public boolean update(Injury injuryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(injuryToUpdate.getPlayerID() == 0)
			return false;
		
		Injury injuryRead = read(injuryToUpdate.getPlayerID(),injuryToUpdate.getSeason());
		if(!injuryRead.equals(injuryToUpdate)) {
			try {
				if(injuryToUpdate.getTypology() == null || injuryToUpdate.getTypology().equals("")) {
					injuryToUpdate.setTypology(injuryRead.getTypology());
				}
				if(injuryToUpdate.getDuration() == 0) {
					injuryToUpdate.setDuration(injuryRead.getDuration());
				}
				if(injuryToUpdate.getGravityIndex() == 0) {
					injuryToUpdate.setGravityIndex(injuryRead.getGravityIndex());
				}
				if(injuryToUpdate.getSeason() == 0) {
					injuryToUpdate.setSeason(injuryRead.getSeason());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, injuryToUpdate.getPlayerID());
				preparedStatement.setString(2, injuryToUpdate.getTypology());
				preparedStatement.setInt(3, injuryToUpdate.getDuration());
				preparedStatement.setInt(4, injuryToUpdate.getGravityIndex());
				preparedStatement.setInt(5, injuryToUpdate.getSeason());
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
}
	