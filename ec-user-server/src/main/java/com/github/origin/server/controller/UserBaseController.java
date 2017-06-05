package com.github.origin.server.controller;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.UserDO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zhu on 2017/6/5.
 */
@RestController
public class UserBaseController {

	//private final Logger logger = Logger.(UserBaseController.class);

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public CommonModel userLogin(@RequestBody UserDO userDO){

		CommonModel cm = new CommonModel();
		UserDO ud = new UserDO();
		ud.setUserName("admin");
		ud.setUserPassword("123");

		if(ud.getUserName().equals(userDO.getUserName()) && ud.getUserPassword().equals(userDO.getUserPassword())) {
			cm.setDataObject(userDO);
		}else{
			cm.setErrorCode("-100001");
			cm.setErrorMessage("账户名或密码错误");
		}

		return cm;
	}
}
