package com.github.origin.client.auth;

import java.io.Serializable;

/**
 * Created by Zhu on 2017/6/12.
 */
public class JwtAuthenticationRequest implements Serializable {

	private String username;
	private String password;

	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
