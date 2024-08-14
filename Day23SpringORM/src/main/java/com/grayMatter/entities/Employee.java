package com.grayMatter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="project23employee")
public class Employee {
	
	@Id
	private int empId;
	private String empName;
	private double empSal;
	private String city;
	@ManyToOne	//in one to many or many to one or other relations if we need to add it to table we need joinColumn(it is for foreign key)
	@JoinColumn(name="departmentId", referencedColumnName = "deptId") // where ever join column is written it creates a column
	private Department department;
	
}
