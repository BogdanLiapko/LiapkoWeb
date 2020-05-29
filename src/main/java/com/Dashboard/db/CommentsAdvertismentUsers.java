package com.Dashboard.db;
import java.io.Serializable;
public class CommentsAdvertismentUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int commId;
	private int userId;
	private int prodId;
	public CommentsAdvertismentUsers() {
		super();
	}
	public CommentsAdvertismentUsers(int commId, int userId, int prodId) {
		super();
		this.commId = commId;
		this.userId = userId;
		this.prodId = prodId;
	}
	public int getCommId() {
		return commId;
	}
	public void setCommId(int commId) {
		this.commId = commId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}
