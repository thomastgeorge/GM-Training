package com.grayMatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Employee;

@Controller
public class EmployeeController {
	
	@RequestMapping("/doLogin")
	public String doLogin() {
		return "addemp";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String uname, @RequestParam String pwd) {
		ModelAndView mv=null;
		if(uname.equals("user") && pwd.equals("12345")) {
			mv=new ModelAndView("welcome");
			mv.addObject("uname", uname);
		} else
			mv=new ModelAndView("login");
		return mv;
	}
//	
//	@RequestMapping("/employee")
//	public ModelAndView getEmpInfo() {
//		Employee emp = new Employee(12, "user");
//		ModelAndView mv = new ModelAndView("emp");
//		mv.addObject("emp1", emp);
//		return mv;
//	}
	
	@RequestMapping("/employee/add")
	public ModelAndView addEmp(@RequestParam String empName, @RequestParam String empId) {
		Employee emp= new Employee(Integer.parseInt(empId), empName);
		ModelAndView mv = new ModelAndView("emp");
		mv.addObject("emp1", emp);
		return mv;
	}
}
