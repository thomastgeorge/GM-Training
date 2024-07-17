package com.grayMatter;

import java.util.Date;

public class Employee extends Person {
	private String deptNme;
	private double sal;
	private Date doj;
	
	public Employee() {
		super();
	}

	public Employee(String name, int id, String mobile, String email, Date dob, String deptNme, double sal, Date doj) {
		super(name, id, mobile, email, dob);
		this.deptNme = deptNme;
		this.sal = sal;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [deptNme=" + deptNme + ", sal=" + sal + ", doj=" + doj + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
