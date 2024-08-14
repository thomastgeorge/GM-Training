package com.grayMatter.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="project23department")
public class Department {
	
	@Id
	private int deptId;
	private String deptName;
	@OneToMany(mappedBy = "department")		//mappedBy is used for bidirectional , /it wont create a column in tables
	@JsonIgnore
	private List<Employee> empList;
}
