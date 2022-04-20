package com.project.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminInfo {
	@Id
	private String email;
	private String password;

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

	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdminInfo [email=" + email + ", password=" + password + "]";
	}

	public AdminInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
