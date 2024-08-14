package com.grayMatter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.DepartmentDao;
import com.grayMatter.entities.Department;

@Service
public class DepartmentService implements DepartmentServiceInterface {

	@Autowired
	DepartmentDao deptDao;
	
	@Override
	public List<Department> getAllDepartment() {

		return deptDao.getAllDepartment();
	}

	@Override
	public Department addDepartment(Department department) {

		return deptDao.addDepartment(department);
	}
	
	

}
