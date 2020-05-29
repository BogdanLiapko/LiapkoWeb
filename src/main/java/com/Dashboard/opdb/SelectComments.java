package com.Dashboard.opdb;
import com.Dashboard.db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class SelectComments {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public ArrayList <Comments> getCommentsbycommId(int insertedCommId){
		ArrayList<Comments> massiveComments = new ArrayList<Comments>();
		String query = "select * from Comments where CommId  = ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1, insertedCommId );
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int commId = queryResult.getInt(1);
					String comm = queryResult.getString(2);
					Comments thisComments = new Comments(commId,comm);
					massiveComments.add(thisComments);
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
		}return massiveComments;
	}
}