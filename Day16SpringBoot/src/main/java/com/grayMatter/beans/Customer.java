package com.grayMatter.beans;

public class Customer {
	
	private String name;
	private int id;
	private int number;
	

	public Customer() {
		super();
	}

	public Customer(String name, int id, int number) {
		super();
		this.name = name;
		this.id = id;
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", number=" + number + "]";
	}

	
	
	

}
