package com.github.origin.web.manage.fallback;

import com.github.origin.web.manage.service.ComputeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhu on 2017/3/1.
 */
@Component
public class ComputeClientHystrix implements ComputeClient{


	@Override
	public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return -9999;
	}

}
