package com.grayMatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.entities.Employee;
import com.grayMatter.exceptions.ResourceNotFoundException;
import com.grayMatter.services.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return empService.getAllEmployee();
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}
	
	@GetMapping("/employee/city/{city}")
	public List<Employee> getAllEmployeeByCity(@PathVariable("city") String city){
		return empService.getAllEmployeeByCity(city);
	}
	
	@GetMapping("/employee/id/{id}")
	public Employee getAllEmployeeById(@PathVariable("id") int id) throws ResourceNotFoundException{
		return empService.getAllEmployeeById(id);
	}
	
	@GetMapping("/employee/dept/{id}")
	public List<Employee> getAllEmployeeByDeptId(@PathVariable("id") int id){
		return empService.getAllEmployeeByDeptId(id);
	}
	
	@GetMapping("/employee/nameStart/{letter}")
	public List<Employee> finaAllEmployeeStartWith(@PathVariable("letter") String letter){
		return empService.finaAllEmployeeStartWith(letter);
	}

}
