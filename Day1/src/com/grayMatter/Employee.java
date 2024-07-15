package com.grayMatter;

import java.util.Scanner;

public class Employee {

	String name;
	int id;
	double sal;
	String mobile;
	String email;
	
	static String companyName; //in a away belongs to the class rather than the objects

	public void setDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name, id, sal, mobile, email");
		this.name=sc.next();
		this.id=sc.nextInt();
		this.sal=sc.nextDouble();
		this.mobile = sc.next();
		this.email = sc.next();
		sc.close();
	}

	public void getDetails() {
		System.out.println("name: "+name+" id: "+id+" sal: "+ sal
				+" mobile: "+ mobile+ " email: "+email);
	}
	
	public Employee(String name, int id, double sal, String mobile, String email) {
		super();
		this.name = name;
		this.id = id;
		this.sal = sal;
		this.mobile = mobile;
		this.email = email;
	}
	
	public Employee() {
		super();
	}
}

