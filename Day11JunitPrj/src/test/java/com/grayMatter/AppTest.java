package com.grayMatter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

	@Test
	public void testPrintName() {
		assertEquals("User", App.printName("User"));
		
	}
	
	@Test
	public void testFindKey() {
		int[] arr = {1,2,3,4,5};
		int key=2;
		assertEquals(2, App.findKey(arr,key));
		
	}

	@Test
	public void testArrayEquals() {
		int[] expArray = {1,2,3,4,5};
		int[] actArray = {1,2,3,4,5};
		assertArrayEquals(expArray, App.araayEquals(actArray));
	}
	
	@Test
	public void testheckSTring() {
		assertNull(App.checkString());
	}
	
	@Test
	public void testCreateStudent() {
		Student expStudent = new Student("user", 123, 22);
		assertEquals(expStudent, App.createStudent());
	}
	
//	@Test
//	public void testConnection() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/graymatterdb", "root", "password");
//		
//		assertEquals(con, DBConnection.getConnection());
//	}
	
	@Test
	public void testCon() throws ClassNotFoundException, SQLException {
		assertNotNull(new DBConnection().getConnection());
	}
	
//	@Before
//	public void printLogBeforeMethod() {
//		System.out.println("Before Every Case");
//	}
//	
//	@After
//	public void printLogAfterMethod() {
//		System.out.println("AFter Every Case");
//	}
//	
//	@BeforeClass
//	public static void printBeforeClass() {
//		System.out.println("Before Class Execution");
//	}
//	
//	@AfterClass
//	public static void printAfterClass() {
//		System.out.println("After Class Execution");
//	}
	
}
