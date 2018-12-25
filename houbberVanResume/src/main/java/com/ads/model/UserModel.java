package com.ads.model;

public class UserModel {

	private Integer id;
	
	private String userName;
	
	private String password;

	private String email;
	
	private String tel;
	
	private String country;
	
	private String state;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/** 默认登录页面名称 */
	private String defaultIndexName;

	/** 期望显示的多个登录页面 */
	private String favorIndexNames;

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

	public String getDefaultIndexName() {
		return defaultIndexName;
	}

	public void setDefaultIndexName(String defaultIndexName) {
		this.defaultIndexName = defaultIndexName;
	}

	public String getFavorIndexNames() {
		return favorIndexNames;
	}

	public void setFavorIndexNames(String favorIndexNames) {
		this.favorIndexNames = favorIndexNames;
	}

}
