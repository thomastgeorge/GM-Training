package com.grayMatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.EmployeeDao;
import com.grayMatter.entities.Employee;
import com.grayMatter.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public List<Employee> getAllEmployee() {
	
		return empDao.getAllEmployee();
	}

	@Override
	public Employee addEmployee(Employee employee) {

		return empDao.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployeeByCity(String city) {
		
		return empDao.getAllEmployeeByCity(city);
	}

	@Override
	public Employee getAllEmployeeById(int id) throws ResourceNotFoundException {

		return empDao.getAllEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployeeByDeptId(int id) {

		return empDao.getAllEmployeeByDeptId(id);
	}

	@Override
	public List<Employee> finaAllEmployeeStartWith(String letter) {

		return empDao.finaAllEmployeeStartWith(letter);
	}

}
