package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Employee;
import com.grayMatter.exceptions.ResourceNotFoundException;
import com.grayMatter.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getAllEmployee(){
		return empRepository.findAll();
	}
	
	public Employee addEmployee(Employee employee) {
		return empRepository.save(employee);
	}
	
	public List<Employee> getAllEmployeeByCity(String city){
		return empRepository.findByCity(city);
	}
	
	public Employee getAllEmployeeById(int id) throws ResourceNotFoundException{
		return empRepository.findById(id).get();
		//.orElseThrow(()->new ResourceNotFoundException("No such Id Found"))
	}
	
	public List<Employee> getAllEmployeeByDeptId(int id){
		return empRepository.findByDepartmentDeptId(id);
	}
	
	public List<Employee> finaAllEmployeeStartWith(String letter){
		return empRepository.findByEmpNameStartingWith(letter);
	}
}
