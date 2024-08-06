package com.grayMatter;

import java.io.Closeable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grayMatter.beans.Customer;
import com.grayMatter.beans.HelloBeans;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	HelloBeans h = new HelloBeans();
//        h.sayHello();
    	
//    	ApplicationContext context = new ClassPathXmlApplicationContext("hello-bean.xml");
//    	HelloBeans hb = (HelloBeans) context.getBean("hello");
//    	hb.sayHello();
//    	
//    	HelloBeans hb1 = (HelloBeans) context.getBean("hello");
//    	hb1.sayHello();
    	
    	ApplicationContext context1 = new ClassPathXmlApplicationContext("hello-bean.xml");
    	Customer c = (Customer) context1.getBean("cust");
    	System.out.println(c);
    	
    	Customer c1 = (Customer) context1.getBean("cust1");
    	System.out.println(c1);
    	
    	
    }
}
