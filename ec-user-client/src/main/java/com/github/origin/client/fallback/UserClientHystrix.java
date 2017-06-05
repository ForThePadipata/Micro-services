package com.github.origin.client.fallback;

import com.github.origin.client.service.UserClient;
import com.github.origin.common.CommonModel;
import com.github.origin.entity.SysUserDO;
import com.github.origin.entity.UserDO;
import org.springframework.stereotype.Component;

/**
 * Created by Zhu on 2017/6/5.
 */
@Component
public class UserClientHystrix implements UserClient{

	@Override
	public CommonModel userLogin(UserDO userDO) {
		CommonModel cm = new CommonModel();
		cm.setErrorCode("-100000");
		cm.setErrorMessage("调用远程接口失败");
		return cm;
	}


}
