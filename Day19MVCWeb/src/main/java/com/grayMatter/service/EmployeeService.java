package com.grayMatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.EmployeeDao;
import com.grayMatter.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	public List<Employee> getAllEmployee(){
		return empDao.getAllEmployee();
	}

	public int addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}
	
	public Employee getEmployeeById(int empId) {
		return empDao.getEmployeeById(empId);
	}
	
	public int updateEmployee(Employee e) {
		return empDao.updateEmployee(e);
	}
	
	public int deleteEmployee(int empId) {
		return empDao.deleteEmployee(empId);
	}
	
}
