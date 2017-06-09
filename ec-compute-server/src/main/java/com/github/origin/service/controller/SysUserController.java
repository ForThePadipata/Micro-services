package com.github.origin.service.controller;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zhu on 2017/5/4.
 */
@RestController
public class SysUserController {

	private final Logger logger = Logger.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/findSysUser", method = RequestMethod.POST)
	public CommonModel findSysUser(@RequestBody SysUser sysUser){

		CommonModel cm = new CommonModel();
		SysUser sud = new SysUser();
		sud.setSysUserName("admin");
		sud.setSysPassword("123");

		if(sud.getSysUserName().equals(sysUser.getSysUserName()) && sud.getSysPassword().equals(sysUser.getSysPassword())){
			cm.setDataObject(sud);
		}else{
			cm.setErrorCode("-100001");
			cm.setErrorMessage("账户名或密码错误");
		}

		return cm;
	}
}
