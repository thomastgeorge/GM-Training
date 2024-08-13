package com.grayMatter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Employee;

import jakarta.annotation.PostConstruct;

@Controller
@ResponseBody
public class EmployeeController {
	List<Employee> empList = new ArrayList<Employee>();
	
	@PostConstruct
	public void setupEmpList() {
		empList.add(new Employee(123, "user1", 1234));
		empList.add(new Employee(124, "user2", 1234));
		empList.add(new Employee(125, "user3", 1234));
	}
	
	@RequestMapping("/employee")
	public ModelAndView getAllEmployee(){
		
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("list", empList);
		return mv;
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		empList.add(employee);
		return employee;
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int empid) {
		for(Employee e: empList) {
			if(e.getEmpId()==empid) {
				return e;
			}
		}
		return null;
	}
	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		for(Employee e: empList) {
			if(e.getEmpId()==id) {
				e.setEmpName(emp.getEmpName());
				e.setEmpSal(emp.getEmpSal());
				return e;
			}
		}
		return null;
	}

}
