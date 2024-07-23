package com.grayMatter;

import java.util.Date;

public class Person {
	private String Name;
	private Date dob;
	private int age;
	
	public Person() {
		super();
	}
	
	public Person(String name, Date dob, int age) {
		super();
		Name = name;
		this.dob = dob;
		this.age = age;
	}

	public String getName() {
		return Name;
	}
	public Date getDob() {
		return dob;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [Name=" + Name + ", dob=" + dob + ", age=" + age + "]";
	}
	
	

}
