package com.grayMatter.services;

import java.util.List;

import com.grayMatter.entities.Employee;
import com.grayMatter.exceptions.ResourceNotFoundException;

public interface EmployeeServiceInterface {

	public List<Employee> getAllEmployee();
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployeeByCity(String city);
	
	public Employee getAllEmployeeById(int id) throws ResourceNotFoundException;
	
	public List<Employee> getAllEmployeeByDeptId(int id);

	public List<Employee> finaAllEmployeeStartWith(String letter);
}
