package com.common.project.model.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "post")
public class Post {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	private String title;
	private String email;
	private String content;
	private int likes;
	private String create_date;
	
	public Post() {
		super();
	}
	
	public Post(Long uid, String title, String email, String content, int likes, String create_date) {
		super();
		this.uid = uid;
		this.title = title;
		this.email = email;
		this.content = content;
		this.likes = likes;
		this.create_date = create_date;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
}
