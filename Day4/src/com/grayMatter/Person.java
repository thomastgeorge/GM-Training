package com.grayMatter;

public class Person {
	private String name;
	private long aadharId;
	private int age;
	
	public Person() {
		super();
	}
	public Person(String name, long aadharId, int age) {
		super();
		this.name = name;
		this.aadharId = aadharId;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAadharId() {
		return aadharId;
	}
	public void setAadharId(long aadharId) {
		this.aadharId = aadharId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", aadharId=" + aadharId + ", age=" + age + "]";
	}
	
	
	
}
