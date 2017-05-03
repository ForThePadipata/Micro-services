package com.github.origin.fallback;

import com.github.origin.entity.SysUserDO;
import com.github.origin.service.SysUserClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhu on 2017/5/3.
 */
@Component
public class SysUserHystrix implements SysUserClient {


	@Override
	public SysUserDO findSysUser(SysUserDO sysUserDO) {
		return null;
	}
}
