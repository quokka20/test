package com.test1;

public class User {

	private String id;
	private String pwd;
	
	public User() {}
	
	public User(String id, String pwd) {
		super();
		setId(id);
		setPwd(pwd);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
