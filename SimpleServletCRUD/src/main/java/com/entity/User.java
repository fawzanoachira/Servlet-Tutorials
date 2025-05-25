package com.entity;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String usertype;
	private String state;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User(String name, String email, String password, String usertype, String state) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.usertype = usertype;
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", usertype=" + usertype + ", state=" + state + "]";
	}

	public User() {
		super();
	}

}
