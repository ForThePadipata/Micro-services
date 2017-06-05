package com.github.origin.client.controller;

import com.github.origin.client.service.UserClient;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.entity.UserDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhu on 2017/6/5.
 */
@RestController
public class UserBaseController {

	@Autowired
	UserClient userClient;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public CommonModel login(UserDO userDO){
		System.out.println("请求成功");
		CommonModel commonModel = userClient.userLogin(userDO);
		if(null == commonModel.getErrorCode() && StringUtils.isEmpty(commonModel.getErrorCode())){
			System.out.println("登录成功");
		}else{

			System.out.println("登录失败");
		}
		return commonModel;
	}



}
