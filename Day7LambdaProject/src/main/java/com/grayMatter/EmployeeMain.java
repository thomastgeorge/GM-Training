package com.grayMatter;

import java.util.ArrayList;
import java.util.function.Function;

public class EmployeeMain {
	
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		
        employees.add(new Employee(1,"Alice", 60000));
        employees.add(new Employee(2, "Bob", 45000));
        employees.add(new Employee(3, "Carol", 55000));
        employees.add(new Employee(4, "David", 40000));
        employees.add(new Employee(5, "Eve", 70000));
        employees.add(new Employee(6, "Frank", 48000));
        
        Function<Employee, Double> applyBonus = employee -> {
            if (employee.getSal() >= 50000) {
                return employee.getSal() + 5000;
            } else {
                return employee.getSal() + 2000;
            }
        };
        
        employees.forEach(employee -> {
            employee.setSal(applyBonus.apply(employee));
        });
        
        System.out.println("Employees with applied bonuses:");
        employees.forEach(System.out::println);
        
	}

}
