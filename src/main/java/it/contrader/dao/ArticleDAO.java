package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Article;

public class ArticleDAO {
	
	private final String QUERY_ALL = "SELECT * FROM article";
	private final String QUERY_CREATE = "INSERT INTO article (name, description,price) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM article WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE article SET name=?, description=?, price=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM article WHERE id=?";

	public ArticleDAO() {

	}

	public List<Article> getAll() {
		List<Article> articleList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Article article;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				int price = resultSet.getInt("price");
				article = new Article(name, description, price);
				article.setId(id);
				articleList.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleList;
	}

	public boolean insert(Article articleToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, articleToInsert.getName());
			preparedStatement.setString(2, articleToInsert.getDescription());
			preparedStatement.setInt(3, articleToInsert.getPrice());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Article read(int articleId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


	        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, articleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name;
			String description;
			int price;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			price = resultSet.getInt("price");
			Article article = new Article(name, description, price);
			article.setId(resultSet.getInt("id"));

			return article;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Article articleToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (articleToUpdate.getId() == 0)
			return false;

		Article articleRead = read(articleToUpdate.getId());
		if (!articleRead.equals(articleToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (articleToUpdate.getName() == null || articleToUpdate.getName().equals("")) {
					articleToUpdate.setName(articleRead.getName());
				}

				if (articleToUpdate.getDescription() == null || articleToUpdate.getDescription().equals("")) {
					articleToUpdate.setDescription(articleRead.getDescription());
				}

				if (articleToUpdate.getPrice()==0) {
					articleToUpdate.setPrice(articleRead.getPrice());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, articleToUpdate.getName());
				preparedStatement.setString(2, articleToUpdate.getDescription());
				preparedStatement.setInt(3, articleToUpdate.getPrice());
				preparedStatement.setInt(4, articleToUpdate.getId());
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
