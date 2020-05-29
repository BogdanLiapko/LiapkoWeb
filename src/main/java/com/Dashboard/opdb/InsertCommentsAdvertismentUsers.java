package com.Dashboard.opdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class InsertCommentsAdvertismentUsers {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public void create(int inputCommId,int inputUserId,int inputProdId) {
		String query = "insert into CommentsAdvertismentUsers(CommId,UserId,ProdId) values(?,?,?)";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1,inputCommId);
				thisQuery.setInt(2, inputUserId);
				thisQuery.setInt(3, inputProdId);
				thisQuery.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("CommentsAdverismentUsers");
		}
	}
}