package com.grayMatter;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.grayMatter.beans.Course;
import com.grayMatter.beans.DataSourceClass;
import com.grayMatter.beans.Order;
import com.grayMatter.beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	ApplicationContext context = new ClassPathXmlApplicationContext("hello-beans.xml");
//    	
//    	Student st1 = (Student) context.getBean("stud1");
//    	System.out.println(st1);
//    	System.out.println(st1.hashCode());
//    	Student st2 = (Student) context.getBean("stud1");
//    	System.out.println(st2);
//    	System.out.println(st2.hashCode());
//    	Student st3 = (Student) context.getBean("stud1");
//    	System.out.println(st3);
//    	System.out.println(st3.hashCode());
//    	
//    	Student st4 = (Student) context.getBean("stud2");
//    	System.out.println(st4);
//    	
//    	Order ord=(Order)context.getBean("ord");
//    	System.out.println(ord);
    	Connection con=null;
    	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("db-beans.xml"));
    	DataSourceClass ds = (DataSourceClass) factory.getBean("dbCon");
    	try {
			con=ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(con!=null)
    	System.out.println("connetion established");
    	

    }
}
