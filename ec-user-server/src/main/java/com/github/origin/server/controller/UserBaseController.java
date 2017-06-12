package com.github.origin.server.controller;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhu on 2017/6/5.
 */
@RestController
public class UserBaseController {

	//private final Logger logger = Logger.(UserBaseController.class);

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public CommonModel userLogin(@RequestBody User user){

		CommonModel cm = new CommonModel();
		User ud = new User();
		ud.setUsername("admin");
		ud.setPassword("123");

		if(ud.getUsername().equals(user.getUsername()) && ud.getPassword().equals(user.getPassword())) {
			cm.setDataObject(user);
		}else{
			cm.setErrorCode("-100001");
			cm.setErrorMessage("账户名或密码错误");
		}

		return cm;
	}


	@RequestMapping(value = "/findUserByUsername", method = RequestMethod.POST)
	public CommonModel findUserByUsername(@RequestBody String username){

		CommonModel cm = new CommonModel();
		User ud = new User();
		ud.setUsername(username);
		ud.setPassword("$2a$10$5x4RgCbQ5fO/1FOk4gxxpO5nBkGyAt5Xqm/GUKOOh4c9Qz8FIgdQy");
		ud.setUserNo("88888888");
		List<String> roleList = new ArrayList<String>();
		roleList.add("ADMIN");
		roleList.add("USER");
		ud.setRoles(roleList);
		cm.setDataObject(ud);

		return cm;
	}


	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public CommonModel regist(@RequestBody User user){

		CommonModel cm = new CommonModel();
		User ud = new User();
		ud.setUsername("TEST");
		ud.setPassword("$2a$10$5x4RgCbQ5fO/1FOk4gxxpO5nBkGyAt5Xqm/GUKOOh4c9Qz8FIgdQy");//123123
		ud.setUserNo("88888888");
		List<String> roleList = new ArrayList<String>();
		roleList.add("ADMIN");
		roleList.add("USER");
		ud.setRoles(roleList);
		cm.setDataObject(ud);

		return cm;
	}

}
