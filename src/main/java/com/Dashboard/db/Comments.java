package com.Dashboard.db;
import java.io.Serializable;
public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int commId;
	private String comm;
	public Comments() {
		super();
	}
	public Comments(String comm) {
		super();
		this.comm = comm;
	}
	public Comments(int commId, String comm) {
		super();
		this.commId = commId;
		this.comm = comm;
	}
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public int getCommId() {
		return commId;
	}
	
}
