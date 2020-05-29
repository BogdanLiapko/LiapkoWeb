package com.Dashboard.opdb;
import com.Dashboard.db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class SelectCommentsAdvertismentUsers {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public ArrayList <CommentsAdvertismentUsers> getCommentsAdvertismentUsersByProdId(int insertedProdId){
		ArrayList<CommentsAdvertismentUsers> massiveCommentsAdvertismentUsers = new ArrayList<CommentsAdvertismentUsers>();
		String query = "select * from CommentsAdvertismentUsers where ProdId  = ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1, insertedProdId);
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int commId = queryResult.getInt(1);
					int userId = queryResult.getInt(2);
					int prodId = queryResult.getInt(3);
					CommentsAdvertismentUsers thisCommentsAdvertismentUsers = new CommentsAdvertismentUsers(commId, userId, prodId);
					massiveCommentsAdvertismentUsers.add(thisCommentsAdvertismentUsers);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("All Comments");
		}return massiveCommentsAdvertismentUsers;
	}
}