package com.grayMatter.services;

import java.util.List;

import com.grayMatter.entities.Department;

public interface DepartmentServiceInterface {
	
	public List<Department> getAllDepartment();

	public Department addDepartment(Department department);

}
