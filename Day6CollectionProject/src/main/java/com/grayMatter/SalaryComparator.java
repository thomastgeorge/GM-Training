package com.grayMatter;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o1.getEmpSal()-o2.getEmpSal());
	}

}
