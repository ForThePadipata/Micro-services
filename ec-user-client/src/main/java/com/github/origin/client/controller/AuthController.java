package com.github.origin.client.controller;

import com.github.origin.client.auth.JwtAuthenticationRequest;
import com.github.origin.client.auth.JwtAuthenticationResponse;
import com.github.origin.client.service.AuthService;
import com.github.origin.client.service.UserClient;
import com.github.origin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhu on 2017/6/12.
 */
@RestController
public class AuthController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest)
		throws Exception{

		final String token = authService.login(authenticationRequest.getUsername(),
												authenticationRequest.getPassword());

		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(@RequestBody HttpServletRequest request )
			throws Exception{

		String token = request.getHeader("token");

		String refreshedToken = authService.refresh(token);
		if(null == refreshedToken){
			return ResponseEntity.badRequest().body(null);
		}else{
			return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
		}
	}

	@RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
	public User register(@RequestBody User user) throws AuthenticationException{

		return authService.register(user);
	}



}
