package com.github.origin.web.manage.service;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.web.manage.fallback.ComputeClientHystrix;
import com.github.origin.web.manage.fallback.SysUserClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Zhu on 2017/5/3.
 */
@FeignClient(value = "ec-compute-service", fallback = SysUserClientHystrix.class)
public interface SysUserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/findSysUser")
	CommonModel findSysUser(SysUserDO sysUserDO);


}
