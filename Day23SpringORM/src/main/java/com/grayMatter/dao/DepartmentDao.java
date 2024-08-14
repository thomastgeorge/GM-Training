package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Department;
import com.grayMatter.repository.DepartmentRepository;

@Repository
public class DepartmentDao {

	@Autowired
	DepartmentRepository deptRepository;
	
	public List<Department> getAllDepartment(){
		return deptRepository.findAll();
	}
	
	public Department addDepartment(Department department) {
		return deptRepository.save(department);
	}
}
