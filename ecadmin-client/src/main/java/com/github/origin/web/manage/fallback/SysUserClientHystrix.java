package com.github.origin.web.manage.fallback;

import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUser;
import com.github.origin.web.manage.service.SysUserClient;
import org.springframework.stereotype.Component;

/**
 * Created by Zhu on 2017/5/3.
 */
@Component
public class SysUserClientHystrix implements SysUserClient {


	@Override
	public CommonModel findSysUser(SysUser sysUser) {
		CommonModel cm = new CommonModel();
		cm.setErrorCode("-100000");
		cm.setErrorMessage("调用远程接口失败");
		return cm;
	}
}
