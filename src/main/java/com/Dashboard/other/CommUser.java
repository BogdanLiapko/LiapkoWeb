package com.Dashboard.other;

import java.io.Serializable;

public class CommUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String comm;
	private String userName;
	
	public CommUser(String comm, String userName) {
		super();
		this.comm = comm;
		this.userName = userName;
	}

	public CommUser() {
		super();
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
