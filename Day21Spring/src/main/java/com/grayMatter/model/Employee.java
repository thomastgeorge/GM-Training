package com.grayMatter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

	private int empId;
	private String empName;
	private double empSal;
	
}
