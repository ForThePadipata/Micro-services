package com.github.origin.client.controller;

import com.github.origin.client.service.UserClient;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.User;
import com.sun.jersey.spi.resource.PerRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Zhu on 2017/6/5.
 */
@RestController
public class UserBaseController {

	@Autowired
	UserClient userClient;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public CommonModel login(User user){
		System.out.println("请求成功");
		CommonModel commonModel = userClient.userLogin(user);
		if(null == commonModel.getErrorCode() && StringUtils.isEmpty(commonModel.getErrorCode())){
			System.out.println("登录成功");
		}else{

			System.out.println("登录失败");
		}
		return commonModel;
	}

	//@PreAuthorize("hasRole('ADMIN')") 这种写法可以忽略"ROLE_"这段字符串 但是后台存储的格式还是"ROLE_ADMIN"
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public CommonModel deleteUser(@PathVariable("id") String id){
		System.out.println("请求成功");
		CommonModel commonModel = new CommonModel();

		return commonModel;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public CommonModel regist(User user) {
		System.out.println("请求成功");

		CommonModel<User> commonModel = userClient.regist(user);

		User regUser = (User)commonModel.getDataObject();

		return commonModel;
	}

}
