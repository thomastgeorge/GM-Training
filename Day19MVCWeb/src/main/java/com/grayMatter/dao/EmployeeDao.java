package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.grayMatter.model.Employee;

@Component
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addEmployee(Employee emp) {
		String query="INSERT INTO employee VALUES ("+emp.getEmpId()+",'"+emp.getEmpName()+"',"+emp.getEmpSal()+");";
		return jdbcTemplate.update(query);
	}
	
	public List<Employee> getAllEmployee(){
		
		String query = "SELECT * FROM employee";
		List<Employee> empList = jdbcTemplate.query(query, new EmployeeRowMapper());
		return empList;
	}
	
	public int updateEmployee(Employee emp) {
		String query="UPDATE employee SET empsal="+emp.getEmpSal()+"WHERE empid="+emp.getEmpId();
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployee(int empId) {
		String query="DELETE FROM employee WHERE empid="+empId;
		return jdbcTemplate.update(query);
	}
	
	public Employee getEmployeeById(int empId) {
		String query="SELECT * FROM employee WHERE empid="+empId;
		List<Employee> empList = jdbcTemplate.query(query, new EmployeeRowMapper());
		return empList.get(0);
	}

}