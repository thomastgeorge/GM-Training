package com.grayMatter.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
public class Department {
	
	@Value("${Department.deptName}")
	private String deptName;
	@Value("${Department.deptId}")
	private String deptId;
	
	
	public Department(String deptName,String deptId) {
		super();
		this.deptName = deptName;
		this.deptId = deptId;
	}


	public Department() {
		super();
	}
	
	

}
