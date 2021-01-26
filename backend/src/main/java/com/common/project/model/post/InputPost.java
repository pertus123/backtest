package com.common.project.model.post;

import lombok.Data;

@Data
public class InputPost {
	private String title;
	private String email;
	private String content;
	private int likes;
	private String create_date;
	public InputPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InputPost(String title, String email, String content, int likes, String create_date) {
		super();
		this.title = title;
		this.email = email;
		this.content = content;
		this.likes = likes;
		this.create_date = create_date; // 지울 것
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
