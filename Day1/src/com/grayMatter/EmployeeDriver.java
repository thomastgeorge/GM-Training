package com.grayMatter;

public class EmployeeDriver {

	public static void main(String[] args) {
		Employee emp = new Employee();
		
		emp.setDetails();
		emp.getDetails();
		
		Employee emp1=new Employee("Thomas", 123, 7000, "1234567890", "thomas@gmail.com");
		emp1.getDetails();

	}

}
