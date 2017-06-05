package com.github.origin.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhu on 2017/6/5.
 */
@Controller
public class BaseController {

	@RequestMapping("/main")
	public void index(ModelMap map, HttpServletResponse response) throws IOException {

		response.sendRedirect("main.html");

	}

}
