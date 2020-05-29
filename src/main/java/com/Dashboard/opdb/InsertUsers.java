package com.Dashboard.opdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertUsers {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public void create(String insertedUserName,String inputPassword,String inputCity,String insertedPhone,String inputAddress) {
		String query = "insert into Users(UserName,Password,City,Phone,Address) values(?,?,?,?,?)";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, insertedUserName);
				thisQuery.setString(2, inputPassword);
				thisQuery.setString(3, inputCity);
				thisQuery.setString(4, insertedPhone);
				thisQuery.setString(5, inputAddress);
				thisQuery.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("User Created");
		}
	}
}
