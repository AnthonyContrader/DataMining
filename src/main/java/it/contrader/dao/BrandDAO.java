package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Brand;

public class BrandDAO implements DAO<Brand> {

	private final String QUERY_ALL = "SELECT * FROM brand";
	private final String QUERY_CREATE = "INSERT INTO brand (name, category) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM brand WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE brand SET name=?, category=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM brand WHERE id=?";

	public BrandDAO() {
	}

	public List<Brand> getAll() {
	List<Brand> brandsList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(QUERY_ALL);
	Brand brand;
	while (resultSet.next()) {
		int id = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String category = resultSet.getString("category");
		
		brand = new Brand(name, category);
		brand.setId(id);
		brandsList.add(brand);
		}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return brandsList;
	}

	public boolean insert(Brand brandToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
	preparedStatement.setString(1, brandToInsert.getName());
	preparedStatement.setString(2, brandToInsert.getCategory());
	
	preparedStatement.execute();
	return true;
	} catch (SQLException e) {
	return false;
	}

	}

	public Brand read(int brandId) {
	Connection connection = ConnectionSingleton.getInstance();
	try {


	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
	preparedStatement.setInt(1, brandId);
	ResultSet resultSet = preparedStatement.executeQuery();
	resultSet.next();
	String name, category;

	name = resultSet.getString("name");
	category = resultSet.getString("category");
	
	Brand brand = new Brand(name,category);
	brand.setId(resultSet.getInt("id"));

	return brand;
	} catch (SQLException e) {
	return null;
	}

	}

	public boolean update(Brand brandToUpdate) {
	Connection connection = ConnectionSingleton.getInstance();

	// Check if id is present
	if (brandToUpdate.getId() == 0)
	return false;

	Brand brandRead = read(brandToUpdate.getId());
	if (!brandRead.equals(brandToUpdate)) {
	try {
	// Fill the userToUpdate object
	if (brandToUpdate.getName() == null || brandToUpdate.getName().equals("")) {
	brandToUpdate.setName(brandRead.getName());
	}

	if (brandToUpdate.getCategory() == null || brandToUpdate.getCategory().equals("")) {
	brandToUpdate.setCategory(brandRead.getCategory());
	}


	PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
	preparedStatement.setString(1, brandToUpdate.getName());
	preparedStatement.setString(2, brandToUpdate.getCategory());
	
	preparedStatement.setInt(3, brandToUpdate.getId());
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
