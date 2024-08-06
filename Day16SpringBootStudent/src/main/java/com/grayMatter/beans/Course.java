package com.grayMatter.beans;

public class Course {
	
	private int id;
	private String name;
	
	public Course() {
		super();
	}
	
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}
