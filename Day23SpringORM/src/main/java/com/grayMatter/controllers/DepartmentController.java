package com.grayMatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.entities.Department;
import com.grayMatter.services.DepartmentService;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/department")
	public List<Department> getAllDepartment(){
		return deptService.getAllDepartment();
	}
	
	@PostMapping("/department")
	public Department addEmployee(@RequestBody Department department) {
		return deptService.addDepartment(department);
	}

}
