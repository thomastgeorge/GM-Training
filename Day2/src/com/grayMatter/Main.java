package com.grayMatter;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Employee e = new Employee();
		System.out.println(e);
		
		@SuppressWarnings("deprecation")
		Employee emp = new Employee("Thomas", 118, "1234567890", "thomas@gmail.com",
				new Date("12/12/01"), "accounts", 12345, new Date("12/12/2025"));
		System.out.println(emp);
		
		System.out.println(emp instanceof Person);
		
	}

}
