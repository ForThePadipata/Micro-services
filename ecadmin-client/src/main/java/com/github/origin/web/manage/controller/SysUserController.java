package com.github.origin.web.manage.controller;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.web.manage.service.SysUserClient;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Zhu on 2017/5/3.
 */
@RestController
public class SysUserController {

	@Autowired
	SysUserClient sysUserClient;

	@ApiOperation(value = "系统管理员登录", notes = "管理员使用账户跟密码登录管理系统")
	@ApiImplicitParam(name = "sysUserDO", value = "系统管理员实体sysUserDO")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public CommonModel login(SysUserDO sysUserDO){
		System.out.println("请求成功");
		CommonModel commonModel = sysUserClient.findSysUser(sysUserDO);
		if(null == commonModel.getErrorCode() && StringUtils.isEmpty(commonModel.getErrorCode())){
			System.out.println("登录成功");
		}else{

			System.out.println("登录失败");
		}
		return commonModel;
	}

//	@ApiOperation(value = "系统管理员登录", notes = "管理员使用账户跟密码登录管理系统")
//	@ApiImplicitParam(name = "sysUserDO", value = "系统管理员实体sysUserDO")
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(SysUserDO sysUserDO){
//		System.out.println("请求成功");
//		ModelAndView modelAndView = new ModelAndView();
//		CommonModel commonModel = sysUserClient.findSysUser(sysUserDO);
//		if(null == commonModel.getErrorCode() && StringUtils.isEmpty(commonModel.getErrorCode())){
//			modelAndView.addObject(commonModel);
//			modelAndView.setViewName("index");
//			System.out.println("登录成功");
//		}else{
//			modelAndView.addObject(commonModel);
//			modelAndView.setViewName("");
//			System.out.println("登录失败");
//		}
//		return modelAndView;
//	}


}
