package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Article;

public class ArticleDAO {
	
	private final String QUERY_ALL = "SELECT * FROM article";
	private final String QUERY_CREATE = "INSERT INTO article (price, description, time) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM article WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE article SET price=?, description=?, time=? WHERE id=?";
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
				int price = resultSet.getInt("price");
				String description = resultSet.getString("description");
				int time = resultSet.getInt("time");
				article = new Article(price, description, time);
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
			preparedStatement.setInt(1, articleToInsert.getPrice());
			preparedStatement.setString(2, articleToInsert.getDescription());
			preparedStatement.setInt(3, articleToInsert.getTime());
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
			String description;
			int price, time;

			price = resultSet.getInt("price");
			description = resultSet.getString("description");
			time = resultSet.getInt("time");
			Article article = new Article(price, description, time);
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
				if (articleToUpdate.getPrice() == null || articleToUpdate.getPrice().equals("")) { //equals va tolto?
					articleToUpdate.setPrice(articleRead.getPrice());
				}

				if (articleToUpdate.getDescription() == null || articleToUpdate.getDescription().equals("")) {
					articleToUpdate.setDEscription(articleRead.getDescription());
				}

				if (articleToUpdate.getTime() == null || articleToUpdate.getTime().equals("")) {
					articleToUpdate.setTime(articleRead.getTime());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, articleToUpdate.getPrice());
				preparedStatement.setString(2, articleToUpdate.getDescription());
				preparedStatement.setInt(3, articleToUpdate.getTime());
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
