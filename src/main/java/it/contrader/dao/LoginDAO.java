package it.contrader.dao;

import it.contrader.main.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM tb_users WHERE username = ? AND password = ?";

	
	public String login (String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			
			statement.setString(1, username);
			statement.setString(2, password);

			String usertype = null;
			
			ResultSet resultSet;
			
			if(statement.executeQuery().next()) {
				resultSet = statement.executeQuery();
				resultSet.next();
				usertype = resultSet.getString("usertype");
			}

			return usertype;
		}
		
		catch (SQLException e) {
			
			return null;
		}
	}
}
