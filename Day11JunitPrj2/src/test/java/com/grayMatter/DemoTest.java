package com.grayMatter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class DemoTest {

	@Test
	public void testPrintName() {
		assertEquals("user", App.printName("user"));
	}
	
	@Test
	public void testFindKey() {
		int[] arr = {1,2,3,4,5};
		int key=2;
		assertEquals(2, App.findKey(arr,key));
		
	}
	
//	@BeforeAll
//	public  void printLogBeforeMethod() {
//		System.out.println("Before Every Case");
//	}
//	
//	@AfterAll
//	public static void printLogAfterMethod() {
//		System.out.println("AFter Every Case");
//	}
//	
//	@BeforeEach
//	public static void printBeforeClass() {
//		System.out.println("Before Class Execution");
//	}
//	
//	@AfterEach
//	public static void printAfterClass() {
//		System.out.println("After Class Execution");
//	}
}
