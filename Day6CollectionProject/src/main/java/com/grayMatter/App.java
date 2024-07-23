package com.grayMatter;

import java.util.ArrayList;
import java.util.Iterator;

public class App 
{
	public static void main( String[] args )
    {
        ArrayList<Employee> empList = new ArrayList<Employee>();
        Employee e1 = new Employee("User1", 001, 2400000, "Blr");
        Employee e2 = new Employee("User3", 003, 5000000, "Hyd");
        Employee e3 = new Employee("User2", 002, 6000000, "Hyd");
        Employee e4 = new Employee("User4", 004, 24000000, "Blr");
        Employee e5 = new Employee("User5", 005, 24000000, "Blr");
        
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        
        System.out.println("ToString Output:");
        System.out.println(empList);
        
        System.out.println("Using Advanced For Loop");
        for(Employee e:empList){
        	System.out.println(e);
        }
        
        System.out.println("Using Iterator");
        Iterator<Employee> itr=empList.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        	
        }
        
        System.out.println("\nSort Operation");
//        Collections.sort(empList);
//        for(Employee e:empList){
//        	System.out.println(e);
//        }
        
        empList.sort(new CityComparator()
        		.thenComparing(new NameComparator())
        		.thenComparing(new SalaryComparator()));
        for(Employee e:empList){
        	System.out.println(e);
        }
        
        
    }
}
