package com.Dashboard.db;
import java.io.Serializable;
public class Users implements Serializable {

	public Users() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String password;
	private String userName;
	private String city;
	private String address;
	private String phone;
	private int permission;
	public Users(String password, String userName, String city, String address, String phone, int permission) {
		super();
		this.password = password;
		this.userName = userName;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.permission = permission;
	}
	public Users(int userId, String password, String userName, String city, String address, String phone,
			int permission) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.permission = permission;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getUserId() {
		return userId;
	} 
}
