package com.github.origin.client.service;

import com.github.origin.client.fallback.UserClientHystrix;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.entity.UserDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Zhu on 2017/6/5.
 */
@FeignClient(value = "ec-user-server", fallback = UserClientHystrix.class)
public interface UserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/userLogin")
	CommonModel userLogin(UserDO userDO);

}
