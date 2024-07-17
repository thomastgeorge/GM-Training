package com.grayMatter;

public class Student {
	
	String name;
	int id;
	
	public Student() {
		super();
	}

	public Student(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	
	

}
