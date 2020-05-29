package com.Dashboard.opdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertAdvertisment {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public void create(int inputUserId,String inputHeader,String inputDescription,double inputPrice,String inputAddress,String inputCategories) {
		String query = "insert into Advertisment(UserId,Header,Description,Price,Adress,Categories) values(?,?,?,?,?,?)";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1,inputUserId);
				thisQuery.setString(2, inputHeader);
				thisQuery.setString(3, inputDescription);
				thisQuery.setDouble(4, inputPrice);
				thisQuery.setString(5, inputAddress);
				thisQuery.setString(6, inputCategories);
				thisQuery.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Advertisment Add");
		}
	}
}
