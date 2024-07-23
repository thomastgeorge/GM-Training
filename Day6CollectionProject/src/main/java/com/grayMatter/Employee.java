package com.grayMatter;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class Employee implements Comparable<Employee> {
	private String empName;
	private int empId;
	private double empSal;
	private String city;
	
	public Employee() {
		super();
	}
	public Employee(String empName, int empId, double empSal, String city) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empSal = empSal;
		this.city = city;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	
	public String getEmpName() {
		return empName;
	}
	public int getEmpId() {
		return empId;
	}
	public double getEmpSal() {
		return empSal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empSal=" + empSal + ", city=" + city + "]";
	}

	@Override
	public int compareTo(Employee o) {
		
		//return this.getEmpId()-o.getEmpId();
		//return (int)(this.getEmpSal()-o.getEmpSal());
				
		return this.getEmpName().compareTo(o.getEmpName());
	}
	
	
	
}
