package com.common.project.model.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String email;
	private String password;
	private String name;
	private String introduce;
	private String profileimage;
	
	@Column(insertable = false, updatable = false)
	private LocalDateTime create_date;
	
	public Member() {
		super();
	}
	public Member(Long uid, String email, String password, String name, String introduce, String profileimage) {
		super();
		this.uid = uid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.introduce = introduce;
		this.profileimage = profileimage;
	}
	public Member(String email, String password, String name) {
		// TODO Auto-generated constructor stub
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}
	public Member(String name, String email, String password, String introduce) {
		// TODO Auto-generated constructor stub
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.introduce = introduce;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getProfileimage() {
		return profileimage;
	}
	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}
}
