package com.common.project.model.member;


import lombok.ToString;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;
@Valid
@ToString
public class InfoInputMember {
    private Long uid;
    private String email;
    private String password;
    private String name;
    private String introduce;
    private MultipartFile profileimage;
    private int profileSwitch;

    public int getProfileSwitch() {
		return profileSwitch;
	}

	public void setProfileSwitch(int profileSwitch) {
		this.profileSwitch = profileSwitch;
	}
    
    

    public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public MultipartFile getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(MultipartFile profileimage) {
		this.profileimage = profileimage;
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

	public InfoInputMember() {
		super();
	}
    
    public InfoInputMember(String email,
           String password, 
            String name, String introduce, int profileSwitch) {
        super();
		this.email = email;
		this.password = password;
        this.name = name;
        this.introduce = introduce;
        this.profileSwitch = profileSwitch;
	}
    
	public InfoInputMember(String email,
             String introduce, 
             String name, String password, MultipartFile profileimage, int profileSwitch) {
		super();
		this.email = email;
		this.password = password;
        this.name = name;
        this.introduce = introduce;
        this.profileimage = profileimage;
        this.profileSwitch = profileSwitch;
    }
}