package com.Dashboard.opdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class UpdateAdvertisment {
	private String url = "jdbc:sqlserver://localhost;database=Dashboard";
	private String login = "Users";
	private String password = "password";
	public void edit(int inputProdId,String inputDescription,double inputPrice,String inputAddress) {
		String query = "update Advertisment set Description = ?,Price = ?, Adress =? where ProdId = ?";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
			Connection connectdb = DriverManager.getConnection(url, login, password);
			try {
				PreparedStatement thisQuery = connectdb.prepareStatement(query);
				thisQuery.setString(1, inputDescription );
				thisQuery.setDouble(2, inputPrice);
				thisQuery.setString(3, inputAddress);
				thisQuery.setInt(4,inputProdId);
				thisQuery.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
			}finally {
				connectdb.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Updated");
		}
	}
}
