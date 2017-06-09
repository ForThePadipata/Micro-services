package com.github.origin.client.auth.factory;

import com.github.origin.client.auth.JwtUser;
import com.github.origin.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhu on 2017/6/9.
 * 创建JwtUser用的工厂类
 */
public final class JwtUserFactory {

	private JwtUserFactory(){

	}

	public static JwtUser create(User user){
		return new JwtUser(
				Integer.toString(user.getId()),
				user.getUserNo(),
				user.getUsername(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getRoles())
		);
	}

	/**
	 * 将String格式的用户角色转换成为security的权限对象
	 * @param authoritites
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authoritites){
		return authoritites.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}





}
