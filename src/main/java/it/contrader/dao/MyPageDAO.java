package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.MyPage;


public class MyPageDAO implements DAO<MyPage> {

	private final String QUERY_ALL = "SELECT * FROM myPage";
	private final String QUERY_CREATE = "INSERT INTO myPage (message, chronology, disputesReports) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM myPage WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE myPage SET message=?, chronology=?, disputesReports=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM myPage WHERE id=?";

	public MyPageDAO() {
	}

	public List<MyPage> getAll() {
	List<MyPage> myPagesList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(QUERY_ALL);
	MyPage myPage;
	while (resultSet.next()) {
		int id = resultSet.getInt("id");
		String message = resultSet.getString("message");
		String chronology = resultSet.getString("chronology");
		String disputeReports = resultSet.getString("disputesReports");
		myPage = new MyPage(message, chronology, disputeReports);
		myPage.setId(id);
		myPagesList.add(myPage);
		}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return myPagesList;
	}

	public boolean insert(MyPage myPageToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
	preparedStatement.setString(1, myPageToInsert.getMessage());
	preparedStatement.setString(2, myPageToInsert.getChronology());
	preparedStatement.setString(3, myPageToInsert.getDisputesReports());
	preparedStatement.execute();
	return true;
	} catch (SQLException e) {
	return false;
	}

	}

	public MyPage read(int myPageId) {
	Connection connection = ConnectionSingleton.getInstance();
	try {


	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
	preparedStatement.setInt(1, myPageId);
	ResultSet resultSet = preparedStatement.executeQuery();
	resultSet.next();
	String message, chronology, disputeReports;

	message = resultSet.getString("message");
	chronology = resultSet.getString("chronology");
	disputeReports = resultSet.getString("disputesReports");
	MyPage myPage = new MyPage(message,chronology, disputeReports);
	myPage.setId(resultSet.getInt("id"));

	return myPage;
	} catch (SQLException e) {
	return null;
	}

	}

	public boolean update(MyPage myPageToUpdate) {
	Connection connection = ConnectionSingleton.getInstance();

	// Check if id is present
	if (myPageToUpdate.getId() == 0)
	return false;

	MyPage myPageRead = read(myPageToUpdate.getId());
	if (!myPageRead.equals(myPageToUpdate)) {
	try {
	// Fill the userToUpdate object
	if (myPageToUpdate.getMessage() == null || myPageToUpdate.getMessage().equals("")) {
	myPageToUpdate.setMessage(myPageRead.getMessage());
	}

	if (myPageToUpdate.getChronology() == null || myPageToUpdate.getChronology().equals("")) {
	myPageToUpdate.setChronology(myPageRead.getChronology());
	}

	if (myPageToUpdate.getDisputesReports() == null || myPageToUpdate.getDisputesReports().equals("")) {
	myPageToUpdate.setDisputesReports(myPageRead.getDisputesReports());
	}


	PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
	preparedStatement.setString(1, myPageToUpdate.getMessage());
	preparedStatement.setString(2, myPageToUpdate.getChronology());
	preparedStatement.setString(3, myPageToUpdate.getDisputesReports());
	preparedStatement.setInt(4, myPageToUpdate.getId());
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