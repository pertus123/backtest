package com.common.project.model.member;

public class SignupInputMember {
	private String email;
	private String password;
	private String name;
	public SignupInputMember() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SignupInputMember(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}
	

}
