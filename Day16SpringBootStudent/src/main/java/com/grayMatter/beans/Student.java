package com.grayMatter.beans;

import java.util.Set;

public class Student {

	private String name;
	private int id;
	private String number;
	private Order order;
	private Set<Course> course;
	
	public Student() {
		super();
	}
	
	public Student(String name, int id, String number, Order order, Set<Course> course) {
		super();
		this.name = name;
		this.id = id;
		this.number = number;
		this.order = order;
		this.course = course;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", number=" + number + ", order=" + order + ", course=" + course
				+ "]";
	}

	
	
}
