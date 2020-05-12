package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Platform;


public class PlatformDAO {
	
	private final String QUERY_ALL = "SELECT * FROM platform";
	private final String QUERY_CREATE = "INSERT INTO platform (name, description, website) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM platform WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE platform SET name=?, description=?, website=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM platform WHERE id=?";

	public PlatformDAO() {
	}

	public List<Platform> getAll() {
		List<Platform> platformsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Platform platform;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String website = resultSet.getString("website");
				platform = new Platform(name, description, website);
				platform.setId(id);
				platformsList.add(platform);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return platformsList;
	}

	public boolean insert(Platform platformToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, platformToInsert.getName());
			preparedStatement.setString(2, platformToInsert.getDescription());
			preparedStatement.setString(3, platformToInsert.getWebsite());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Platform read(int platformId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, platformId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description, website;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			website = resultSet.getString("website");
			Platform platform = new Platform(name,description, website);
			platform.setId(resultSet.getInt("id"));

			return platform;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Platform platformToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (platformToUpdate.getId() == 0)
			return false;

		Platform platformRead = read(platformToUpdate.getId());
		if (!platformRead.equals(platformToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (platformToUpdate.getName() == null || platformToUpdate.getName().equals("")) {
					platformToUpdate.setName(platformRead.getName());
				}

				if (platformToUpdate.getDescription() == null || platformToUpdate.getDescription().equals("")) {
					platformToUpdate.setDescription(platformRead.getDescription());
				}

				if (platformToUpdate.getWebsite() == null || platformToUpdate.getWebsite().equals("")) {
					platformToUpdate.setWebsite(platformRead.getWebsite());
				}

				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, platformToUpdate.getName());
				preparedStatement.setString(2, platformToUpdate.getDescription());
				preparedStatement.setString(3, platformToUpdate.getWebsite());
				preparedStatement.setInt(4, platformToUpdate.getId());
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
