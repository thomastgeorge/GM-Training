package com.grayMatter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class DemoController {

	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView doLogin() {
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}
}
