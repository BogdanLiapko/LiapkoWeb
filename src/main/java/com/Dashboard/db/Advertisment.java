package com.Dashboard.db;
import java.io.Serializable;
public class Advertisment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int prodId;
	private int userId;
	private String header;
	private String description;
	private double price;
	private String address;
	private String categorie;
	public Advertisment() {
		super();
	}
	public Advertisment(int userId, String header, String description, double price, String address, String categorie) {
		super();
		this.userId = userId;
		this.header = header;
		this.description = description;
		this.price = price;
		this.address = address;
		this.categorie = categorie;
	}
	public Advertisment(int prodId, int userId, String header, String description, double price, String address,
			String categorie) {
		super();
		this.prodId = prodId;
		this.userId = userId;
		this.header = header;
		this.description = description;
		this.price = price;
		this.address = address;
		this.categorie = categorie;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getProdId() {
		return prodId;
	}

}
