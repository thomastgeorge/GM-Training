package com.grayMatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Setter
//@Getter
//@PropertySource("classpath:data.properties")
public class Employee {
	
//	//Setter based Injection
//	@Value("User")
//	private String empName;
//	@Value("12")
//	private int empId;
//	@Value("92883920.18")
//	private double empSal;
	
	
	@Value("${Employee.empName}")
	private String empName;
	@Value("${Employee.empId}")
	private int empId;
	@Value("${Employee.empSal}")
	private double empSal;
	
	@Autowired
	private Department department;

	public Employee() {
		super();
	}
	
	@Autowired
	public Employee(String empName, int empId, double empSal, Department department) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empSal = empSal;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empSal=" + empSal + ", department=" + department
				+ "]";
	}

	

}
