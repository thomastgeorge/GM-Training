package com.grayMatter;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grayMatter.doa.EmployeeDoa;
import com.grayMatter.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("jdbc-bean.xml");
        EmployeeDoa doa=(EmployeeDoa) context.getBean("empdao");
        int count=0;
//        count= doa.addEmployee(new Employee(2,"user2",3000));
//        if(count==1) {
//        	System.out.println("row added");
//        } else {
//        	System.out.println("ERROR: did not add the record to db;");
//        }
        
        List<Employee> empList = doa.getAllEmployee();
        for(Employee e: empList) {
        	System.out.println(e);
        }
        
        count=doa.updateEmployee(new Employee(12,"user12", 22000000));
        if(count==1) {
        	System.out.println("Updated the record");
        } else {
        	System.out.println("ERROR: did not updated the record in db;");
        }
        empList = doa.getAllEmployee();
        for(Employee e: empList) {
        	System.out.println(e);
        }
        
        count=doa.deleteEmployee(new Employee(12,"user12", 22000000));
        if(count==1) {
        	System.out.println("deleted record");
        } else {
        	System.out.println("ERROR: did not update the record in db;");
        }
        empList = doa.getAllEmployee();
        for(Employee e: empList) {
        	System.out.println(e);
        }
        
        //get employee by Id
        System.out.println("Employee By Id");
        System.out.println(doa.getEmployeeById(1));
    }
}
