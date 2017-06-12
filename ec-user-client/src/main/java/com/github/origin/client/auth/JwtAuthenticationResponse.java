package com.github.origin.client.auth;

import java.io.Serializable;

/**
 * Created by Zhu on 2017/6/12.
 */
public class JwtAuthenticationResponse implements Serializable {

	private final String token;

	public JwtAuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
