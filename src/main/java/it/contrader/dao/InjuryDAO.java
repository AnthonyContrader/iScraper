package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Injury;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InjuryDAO {
	private final String QUERY_ALL = "SELECT * FROM tb_injuries";
	private final String QUERY_CREATE = "INSERT into tb_injuries (severity, description, duration, date, player_id) values (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM tb_injuries WHERE id=?";
	private final String QUERY_UPDATE= "UPDATE tb_injuries SET severity=?, description=?, date=?, duration=?, player_id=? WHERE id=?";
	private final String QUERY_DELETE= "DELETE FROM tb_injuries WHERE id=?";

	public InjuryDAO() {}
	
	public List<Injury> getAllInjury() {
			List<Injury> injuryList=new ArrayList<>();
			Connection connection = ConnectionSingleton.getInstance();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				///////
				Injury injury;
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					int severity = resultSet.getInt("severity");
					String description = resultSet.getString("description");
					int duration = resultSet.getInt("duration");
					String date = resultSet.getString("date");
					int player_id = resultSet.getInt("player_id");
					
					injury = new Injury(id, severity, description, duration, date, player_id);
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
			preparedStatement.setInt(1,injuryToUpdate.getSeverity());
			preparedStatement.setString(2,injuryToUpdate.getDescription());
			preparedStatement.setInt(3,injuryToUpdate.getDuration());
			preparedStatement.setString(4,injuryToUpdate.getDate());
			preparedStatement.setInt(5,injuryToUpdate.getPlayer_id());
			preparedStatement.execute();
			return true;
		} catch(SQLException e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Injury read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int player_id = resultSet.getInt("player_id");
			int severity = resultSet.getInt("severity");
			String description = resultSet.getString("description");
			String date = resultSet.getString("date");
			int duration = resultSet.getInt("duration");
			
			Injury injury = new Injury(id, severity, description, duration, date, player_id);
			
			return injury;
		} catch(SQLException e) {
			return null;
		}
	}
	
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
	
	public boolean update(Injury injuryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(injuryToUpdate.getId() == 0)
			return false;
		
		Injury injuryRead = read(injuryToUpdate.getId());
		if(!injuryRead.equals(injuryToUpdate)) {
			try {
				if(injuryToUpdate.getSeverity() == 0) {
					injuryToUpdate.setSeverity(injuryRead.getSeverity());
				}
				if(injuryToUpdate.getDuration() == 0) {
					injuryToUpdate.setDuration(injuryRead.getDuration());
				}
				if(injuryToUpdate.getDescription() == null || injuryToUpdate.getDescription() == "") {
					injuryToUpdate.setDescription(injuryRead.getDescription());
				}
				if(injuryToUpdate.getDate() == null) {
					injuryToUpdate.setDate(injuryRead.getDate());
				}
				if(injuryToUpdate.getPlayer_id() == 0) {
					injuryToUpdate.setPlayer_id(injuryToUpdate.getPlayer_id());
				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(6,injuryToUpdate.getId());
				preparedStatement.setInt(1,injuryToUpdate.getSeverity());
				preparedStatement.setString(2,injuryToUpdate.getDescription());
				preparedStatement.setInt(3,injuryToUpdate.getDuration());
				preparedStatement.setString(4,injuryToUpdate.getDate());
				preparedStatement.setInt(5,injuryToUpdate.getPlayer_id());
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
	