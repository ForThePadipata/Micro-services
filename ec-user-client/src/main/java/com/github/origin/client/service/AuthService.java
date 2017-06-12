package com.github.origin.client.service;

import com.github.origin.entity.User;

/**
 * Created by Zhu on 2017/6/12.
 */
public interface AuthService {

	User register(User userToAdd);
	String login(String username, String password) throws Exception;
	String refresh(String oldToken);

}
