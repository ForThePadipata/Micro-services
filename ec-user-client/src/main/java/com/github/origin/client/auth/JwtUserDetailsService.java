package com.github.origin.client.auth;

import com.github.origin.client.auth.factory.JwtUserFactory;
import com.github.origin.client.service.UserClient;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Zhu on 2017/6/9.
 */
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserClient userClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		CommonModel cm = userClient.findUserByUsername(username);

		User user = (User)cm.getDataObject();

		if(null == user){
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		}else{
			return JwtUserFactory.create(user);
		}

	}

}