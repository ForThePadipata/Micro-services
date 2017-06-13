package com.github.origin.client.service;

import com.github.origin.client.auth.JwtTokenUtil;
import com.github.origin.client.auth.JwtUser;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Zhu on 2017/6/12.
 */
@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserClient userClient;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

//	@Autowired
//	public AuthServiceImpl(
//			AuthenticationManager authenticationManager,
//			UserDetailsService userDetailsService,
//			JwtTokenUtil jwtTokenUtil,
//			UserClient userClient) {
//		this.authenticationManager = authenticationManager;
//		this.userDetailsService = userDetailsService;
//		this.jwtTokenUtil = jwtTokenUtil;
//		this.userClient = userClient;
//	}

	@Override
	public User register(User userToAdd) {
		final String username = userToAdd.getUsername();
//		if(userClient.findUserByUsername(username)!=null) {
//			return null;
//		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		final String rawPassword = userToAdd.getPassword();
		userToAdd.setPassword(encoder.encode(rawPassword));
		//userToAdd.setLastPasswordResetDate(new Date());
		userToAdd.setRoles(asList("ROLE_USER"));

		CommonModel<User> cm = userClient.regist(userToAdd);

		User user = (User)cm.getDataObject();
		return user;
	}

	@Override
	public String login(String username, String password) throws Exception{
		UsernamePasswordAuthenticationToken upToken =
				new UsernamePasswordAuthenticationToken(username, password);
		//登陆验证时，通过username获取用户的所有权限信息，
		//并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
		final Authentication authentication = authenticationManager.authenticate(upToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		final String token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public String refresh(String oldToken) {
		final String token = oldToken.substring(tokenHead.length());
		String username = jwtTokenUtil.getUsernameFromToken(token);
		JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//		if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
//			return jwtTokenUtil.refreshToken(token);
//		}
		return jwtTokenUtil.refreshToken(token);
	}
}
