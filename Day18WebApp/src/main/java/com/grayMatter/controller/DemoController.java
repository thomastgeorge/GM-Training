package com.grayMatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/name")
	public String printName(Model model) {
		model.addAttribute("name", "user");
		return "user";
	}

}
