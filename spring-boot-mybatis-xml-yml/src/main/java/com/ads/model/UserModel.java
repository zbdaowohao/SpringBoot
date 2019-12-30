package com.ads.model;

import java.util.Date;

import com.google.gson.Gson;

public class UserModel {

	private Integer id;

	private String userName;

	private String role;

	private Date today;

	private String desc;

	public UserModel() {
		super();
	}

	public UserModel(String userName, String role) {
		super();
		this.userName = userName;
		this.role = role;
		this.today = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
