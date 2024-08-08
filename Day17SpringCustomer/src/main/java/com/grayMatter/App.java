package com.grayMatter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grayMatter.beans.Customer;
import com.grayMatter.beans.DBUtils;
import com.grayMatter.beans.DataSource;
import com.grayMatter.beans.Regions;
import com.grayMatter.config.CustomerConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfig.class);
//    	Customer c = (Customer) context.getBean("cust");
//    	System.out.println(c);
    	
    	Connection con=null;
    	
    	DataSource ds = (DataSource) context.getBean(DataSource.class);
    	try {
			con = ds.getConnection();
			System.out.println("Connection done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	DBUtils dbu = (DBUtils) context.getBean(DBUtils.class);
    	dbu.setCon(con);
    	
    	//printing the records
    	List<Regions> rlist = dbu.getAll();
    	for(Regions r:rlist) {
    		System.out.println(r);
    	}
    	
    	Regions r = dbu.addRegion(new Regions(6, "africa"));
    	System.out.println(r);
    	
    	//printing the records
    	rlist = dbu.getAll();
    	for(Regions r1:rlist) {
    		System.out.println(r1);
    	}
    	dbu.removeRegion(123);
    	
    	//printing the records
    	rlist = dbu.getAll();
    	for(Regions r1:rlist) {
    		System.out.println(r1);
    	}
    	
    	r = dbu.updateRegion(new Regions(6, "Africa"));
    	System.out.println(r);
    }
}
