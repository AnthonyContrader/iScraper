package it.contrader.dao;


import it.contrader.utils.ConnectionSingleton;

import it.contrader.model.Statsbox;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StatsboxDAO implements DAO<Statsbox> {
	private final String QUERY_ALL = "SELECT * FROM tb_stats";
	private final String QUERY_CREATE = "INSERT INTO tb_stats (id,player_id, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM tb_stats WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE tb_stats SET player_id=?, season=?, team=?, caps=?, contributions=?, shotsper=?, keypass=?, passprec=?, dribbling=?, foulssub=?, foulscomm=?, tackles=?, tacklesper=?, breaks=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM tb_stats WHERE id=?";

	
	public StatsboxDAO() {
		
	}
	
	public List<Statsbox> getAll() {
			List<Statsbox> statsList = new ArrayList<>();
			Connection connection = ConnectionSingleton.getInstance();
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QUERY_ALL);
				Statsbox statsbox;
				while (resultSet.next()) {
					int id = resultSet.getInt("id");

					int playerId = resultSet.getInt("player_id");
					int season = Integer.parseInt(resultSet.getString("season"));
					String team = resultSet.getString("team");
					int caps = resultSet.getInt("caps");
					float contributions = resultSet.getFloat("contributions");
					float shotsper = resultSet.getFloat("shotsper");
					float keypass = resultSet.getFloat("keypass");
					float passprec = resultSet.getFloat("passprec");
					float dribbling = resultSet.getFloat("dribbling");
					float foulssub = resultSet.getFloat("foulssub");
					float foulscomm = resultSet.getFloat("foulscomm");
					float tackles = resultSet.getFloat("tackles");
					float tacklesper = resultSet.getFloat("tacklesper");
					float breaks = resultSet.getFloat("breaks");
					
					statsbox = new Statsbox(id,playerId, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);

					statsList.add(statsbox);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return statsList;
	}
	
	public boolean insert(Statsbox statsboxToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, statsboxToUpdate.getId());
			preparedStatement.setInt(2, statsboxToUpdate.getPlayerId());
			preparedStatement.setInt(3, statsboxToUpdate.getSeason());
			preparedStatement.setString(4, statsboxToUpdate.getTeam());
			preparedStatement.setInt(5, statsboxToUpdate.getCaps());
			preparedStatement.setFloat(6, statsboxToUpdate.getContributions());
			preparedStatement.setFloat(7, statsboxToUpdate.getShotsper());
			preparedStatement.setFloat(8, statsboxToUpdate.getKeypass());
			preparedStatement.setFloat(9, statsboxToUpdate.getPassprec());
			preparedStatement.setFloat(10, statsboxToUpdate.getDribbling());
			preparedStatement.setFloat(11, statsboxToUpdate.getFoulssub());
			preparedStatement.setFloat(12, statsboxToUpdate.getFoulscomm());
			preparedStatement.setFloat(13, statsboxToUpdate.getTackles());
			preparedStatement.setFloat(14, statsboxToUpdate.getTacklesper());
			preparedStatement.setFloat(15, statsboxToUpdate.getBreaks());

			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	
	public boolean update(Statsbox statsboxToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present

		if (statsboxToUpdate.getId() == 0)
			return false;

		Statsbox statsboxRead = read(statsboxToUpdate.getId());
		if (!statsboxRead.equals(statsboxToUpdate)) {
			try {
				// Fill the statsboxToUpdate object
				if (statsboxToUpdate.getPlayerId() == 0) {
					statsboxToUpdate.setPlayerId(statsboxRead.getId());
				}
				
				if (statsboxToUpdate.getSeason() == 0) {
					statsboxToUpdate.setSeason(statsboxRead.getSeason());
				}

				if (statsboxToUpdate.getTeam() == null || statsboxToUpdate.getTeam().equals("")) {
					statsboxToUpdate.setTeam(statsboxRead.getTeam());
				}

				if (statsboxToUpdate.getCaps() == 0) {
					statsboxToUpdate.setCaps(statsboxRead.getCaps());
				}

				if (statsboxToUpdate.getContributions() == 0) {
					statsboxToUpdate.setContributions(statsboxRead.getContributions());
				}
				
				if (statsboxToUpdate.getShotsper() == 0) {
					statsboxToUpdate.setShotsper(statsboxRead.getShotsper());
				}
				
				if (statsboxToUpdate.getKeypass() == 0) {
					statsboxToUpdate.setKeypass(statsboxRead.getKeypass());
				}
				
				if (statsboxToUpdate.getPassprec() == 0) {
					statsboxToUpdate.setPassprec(statsboxRead.getPassprec());
				}
				
				if (statsboxToUpdate.getDribbling() == 0) {
					statsboxToUpdate.setDribbling(statsboxRead.getDribbling());
				}
				
				if (statsboxToUpdate.getFoulssub() == 0) {
					statsboxToUpdate.setFoulssub(statsboxRead.getFoulssub());
				}
				
				if (statsboxToUpdate.getFoulscomm() == 0) {
					statsboxToUpdate.setFoulscomm(statsboxRead.getFoulscomm());
				}
				
				if (statsboxToUpdate.getTackles() == 0) {
					statsboxToUpdate.setTackles(statsboxRead.getTackles());
				}
				
				if (statsboxToUpdate.getTacklesper() == 0) {
					statsboxToUpdate.setTacklesper(statsboxRead.getTacklesper());
				}
				
				if (statsboxToUpdate.getBreaks() == 0) {
					statsboxToUpdate.setBreaks(statsboxRead.getBreaks());
				}

				// Update the statsbox
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, statsboxToUpdate.getPlayerId());
				preparedStatement.setInt(2, statsboxToUpdate.getSeason());
				preparedStatement.setString(3, statsboxToUpdate.getTeam());
				preparedStatement.setObject(5, statsboxToUpdate.getContributions());
				preparedStatement.setInt(4, statsboxToUpdate.getCaps());
				preparedStatement.setFloat(6, statsboxToUpdate.getShotsper());
				preparedStatement.setFloat(7, statsboxToUpdate.getKeypass());
				preparedStatement.setFloat(8, statsboxToUpdate.getPassprec());
				preparedStatement.setFloat(9, statsboxToUpdate.getDribbling());
				preparedStatement.setFloat(10, statsboxToUpdate.getFoulssub());
				preparedStatement.setFloat(11, statsboxToUpdate.getFoulscomm());
				preparedStatement.setFloat(12, statsboxToUpdate.getTackles());
				preparedStatement.setFloat(13, statsboxToUpdate.getTacklesper());
				preparedStatement.setFloat(14, statsboxToUpdate.getBreaks());
				preparedStatement.setInt(15, statsboxToUpdate.getId());
				
				int a = preparedStatement.executeUpdate();
				if (a > 0) {
					return true;
				}
					
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}
	

	public Statsbox read (int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int player_id = resultSet.getInt("player_id");
			int season = resultSet.getInt("season");
			String team = resultSet.getString("team");
			int caps = resultSet.getInt("caps");
			float contributions = resultSet.getFloat("contributions");
			float shotsper = resultSet.getFloat("shotsper");
			float keypass = resultSet.getFloat("keypass");
			float passprec = resultSet.getFloat("passprec");
			float dribbling = resultSet.getFloat("dribbling");
			float foulssub = resultSet.getFloat("foulssub");
			float foulscomm = resultSet.getFloat("foulscomm");
			float tackles = resultSet.getFloat("tackles");
			float tacklesper = resultSet.getFloat("tacklesper");
			float breaks = resultSet.getFloat("breaks");
			
			Statsbox statsbox = new Statsbox(id, player_id, season, team, caps, contributions, shotsper, keypass, passprec, dribbling, foulssub, foulscomm, tackles, tacklesper, breaks);

			return statsbox;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean delete (int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);

			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
			else return false;

		} catch (SQLException e) {
		}
		return false;
	}
}
