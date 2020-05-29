package com.Dashboard.opdb;
import com.Dashboard.db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class SelectUsers {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public ArrayList <Users> getUsersbylogin(String insertedLogin){
		ArrayList<Users> massiveUsers = new ArrayList<Users>();
		String query = "select * from Users where UserName  =  ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, insertedLogin);
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int userId = queryResult.getInt(1);
					String password = queryResult.getString(2);
					String userName = queryResult.getString(3);
					String city = queryResult.getString(4);
					String address = queryResult.getString(5);
					String phone = queryResult.getString(6);
					int permission = queryResult.getInt(7);
					Users users = new Users(userId,password,userName,city,address,phone,permission);
					massiveUsers.add(users);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("User find successful by login");
		}return massiveUsers;
	}
	public ArrayList <Users> getUsersbyphone(String insertedPhone){
		ArrayList<Users> massiveUsers = new ArrayList<Users>();
		String query = "select * from Users where Phone  =  ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, insertedPhone);
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int userId = queryResult.getInt(1);
					String password = queryResult.getString(2);
					String userName = queryResult.getString(3);
					String city = queryResult.getString(4);
					String address = queryResult.getString(5);
					String phone = queryResult.getString(6);
					int permission = queryResult.getInt(7);
					Users users = new Users(userId,password,userName,city,address,phone,permission);
					massiveUsers.add(users);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("User find successful by login");
		}return massiveUsers;
	}
	public ArrayList <Users> getUsersbyId(int insertedId){
		ArrayList<Users> massiveUsers = new ArrayList<Users>();
		String query = "select * from Users where UserId  =  ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1, insertedId);
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int userId = queryResult.getInt(1);
					String password = queryResult.getString(2);
					String userName = queryResult.getString(3);
					String city = queryResult.getString(4);
					String address = queryResult.getString(5);
					String phone = queryResult.getString(6);
					int permission = queryResult.getInt(7);
					Users users = new Users(userId,password,userName,city,address,phone,permission);
					massiveUsers.add(users);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("User find successful by login");
		}return massiveUsers;
	}
}
