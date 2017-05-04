package com.github.origin.web.manage.service;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.fallback.ComputeClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhu on 2017/5/3.
 */
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface SysUserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/findSysUser")
	CommonModel findSysUser(SysUserDO sysUserDO);


}
