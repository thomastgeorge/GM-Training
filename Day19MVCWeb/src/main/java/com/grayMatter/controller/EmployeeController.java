package com.grayMatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Employee;
import com.grayMatter.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/home")
	public String home() {
	    return "home";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	
	@RequestMapping("/viewById")
	public String viewById() {
		return "getId";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String name, @RequestParam String pwd) {
		ModelAndView mv=null;
		if(name.equals("User") && pwd.equals("12345")) {
			mv=new ModelAndView("home");
			mv.addObject("name", name);
		} else
			mv=new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/add/employee")
	public String addEmployee(@RequestParam String id, @RequestParam String name, @RequestParam String sal) {
		Employee e = new Employee(Integer.parseInt(id), name, Double.parseDouble(sal));
		service.addEmployee(e);
		return "redirect:/home";
	}
	
	@RequestMapping("/viewAll")
	public ModelAndView getAllEmployees(){
		List<Employee> empList = service.getAllEmployee();
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("list", empList);
		mv.addObject("action", "All");
		return mv;
	}
	
	@RequestMapping("/viewById/display")
	public ModelAndView getIdDisplay(@RequestParam String id) {
		Employee e = service.getEmployeeById(Integer.parseInt(id));
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("item", e);
		mv.addObject("action", "Individual");
		return mv;
	}
	
	@RequestMapping("/update/employee")
	public String updateEmployee(@RequestParam String id, @RequestParam String sal) {
		Employee e = new Employee(Integer.parseInt(id), "null", Double.parseDouble(sal));
		service.updateEmployee(e);
		return "redirect:/home";
	}
	
	@RequestMapping("/delete/employee")
	public String deleteEmployee(@RequestParam String id) {
		service.deleteEmployee(Integer.parseInt(id));
		return "redirect:/home";
	}
}
