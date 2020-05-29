package com.Dashboard.opdb;
import com.Dashboard.db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class SelectAdvertisment {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public ArrayList <Advertisment> getAdvertisment(){
		ArrayList<Advertisment> massiveAdvertisments = new ArrayList<Advertisment>();
		String query = "select * from Advertisment";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int prodId = queryResult.getInt(1);
					int userId = queryResult.getInt(2);
					String header = queryResult.getString(3);
					String description = queryResult.getString(4);
					double price = queryResult.getDouble(5);
					String address = queryResult.getString(6);
					String categories = queryResult.getString(7);
					Advertisment thisAdvertisment = new Advertisment(prodId, userId, header, description, price, address, categories);
					massiveAdvertisments.add(thisAdvertisment);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("All Advertisments");
		}return massiveAdvertisments;
	}
	public ArrayList <Advertisment> getAdvertismentbyId(int inputProdId){
		ArrayList<Advertisment> massiveAdvertisments = new ArrayList<Advertisment>();
		String query = "select * from Advertisment where ProdId = ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setInt(1, inputProdId );
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int prodId = queryResult.getInt(1);
					int userId = queryResult.getInt(2);
					String header = queryResult.getString(3);
					String description = queryResult.getString(4);
					double price = queryResult.getDouble(5);
					String address = queryResult.getString(6);
					String categories = queryResult.getString(7);
					Advertisment thisAdvertisment = new Advertisment(prodId, userId, header, description, price, address, categories);
					massiveAdvertisments.add(thisAdvertisment);
				}
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("All Advertisments By Id");
		}return massiveAdvertisments;
	}
	public ArrayList <Advertisment> getAdvertismentbyCategories(String inputCategories){
		ArrayList<Advertisment> massiveAdvertisments = new ArrayList<Advertisment>();
		String query = "select * from Advertisment where Categories = ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, inputCategories );
				ResultSet queryResult = thisQuery.executeQuery();
				while(queryResult.next()) {
					int prodId = queryResult.getInt(1);
					int userId = queryResult.getInt(2);
					String header = queryResult.getString(3);
					String description = queryResult.getString(4);
					double price = queryResult.getDouble(5);
					String address = queryResult.getString(6);
					String categories = queryResult.getString(7);
					Advertisment thisAdvertisment = new Advertisment(prodId, userId, header, description, price, address, categories);
					massiveAdvertisments.add(thisAdvertisment);
				}
			} catch (Exception e) {
			System.out.println(e);
			}finally {
			connectdb.close();
			}
		} catch (Exception e) {
		System.out.println(e);
		}finally {
		System.out.println("All Advertisments By Categories");
		}return massiveAdvertisments;
	}
}
	
