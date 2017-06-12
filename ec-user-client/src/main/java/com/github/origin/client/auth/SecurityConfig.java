package com.github.origin.client.auth;

import com.github.origin.client.auth.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Zhu on 2017/6/7.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Spring会自动寻找同样类型的具体类注入, 这里就是JwtUserDetailsservice了
	@Autowired
	private UserDetailsService userDetailsService;

	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)
		throws Exception {
		authenticationManagerBuilder
				// 设置UserDetailsService
				.userDetailsService(this.userDetailsService)
				// 使用BCrypt进行密码的hash
				.passwordEncoder(passwordEncoder());


	}

	@Autowired
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	//由于使用的是JWT，这里我们不需要csrf
				.csrf().disable()
				//基于token，所以不需要session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				//允许对于网站静态资源的无授权访问
				.antMatchers(
						HttpMethod.GET,
						"/",
						"/*.html",
						"/favicon.ico",
						"/**/*.html",
						"/**/*.css",
						"/**/*.js"
				).permitAll()
				//对于获取token的rest api要允许匿名访问
				.antMatchers("/auth/**").permitAll()
				//除上面外的所有请求全部需要鉴权认证
				.anyRequest().authenticated();
		//添加JWT filter
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		//禁用缓存
		http.headers().cacheControl();
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationTokenFilter();
	}



}
