package com.github.origin.client.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Zhu on 2017/6/9.
 */
public class JwtUser implements UserDetails {

	private final String id;
	private final String userNo;
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;

	public JwtUser(
			String id,
			String userNo,
			String username,
			String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.userNo = userNo;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}


	//返回分配给用户的角色列表
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@JsonIgnore
	public String getId(){
		return id;
	}

	@JsonIgnore
	public String getUserNo(){
		return userNo;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	//账号是否未过期
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//账号是否未锁定
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//密码是否未过期
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//账户是否激活
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}
}
