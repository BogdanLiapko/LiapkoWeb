package com.Dashboard.opdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class InsertComments {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public int create(String inputComm) {
		String query = "insert into Comments(Comm) values(?)";
		String getQuery = "select top 1 * from Comments Order By CommID desc";
		int currentCommId = 0; 
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, inputComm);
				thisQuery.executeUpdate();
				Statement statement = connectdb.createStatement();
				ResultSet resultSet = statement.executeQuery(getQuery);
				while (resultSet.next()) {
					currentCommId = resultSet.getInt(1);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Comments");
		}
		return currentCommId;
	}
}
