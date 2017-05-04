package com.github.origin.web.manage.controller;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.web.manage.service.SysUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhu on 2017/5/3.
 */
@RestController
public class SysUserController {

	@Autowired
	SysUserClient sysUserClient;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public CommonModel login(SysUserDO sysUserDO){
		System.out.println("请求成功");
		return sysUserClient.findSysUser(sysUserDO);
	}


}
