package com.github.origin.web.manage.service;

import com.github.origin.web.manage.fallback.ComputeClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zhu on 2017/3/1.
 */
@FeignClient(value = "ec-compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

	@RequestMapping(method = RequestMethod.GET, value = "/add")
	Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);



}
