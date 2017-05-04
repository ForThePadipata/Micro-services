package com.github.origin.web.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhu on 2017/3/8.
 */
@Controller
public class HellowController {

	@RequestMapping("/")
	public String index(ModelMap map){

		map.addAttribute("host", "http://www.oright.com");

		return "index";
	}

}
