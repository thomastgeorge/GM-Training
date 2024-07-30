package com.grayMatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {
	
	HelloClass hc = new HelloClass();
			
	@Test
	public void testSayHello() {
		String expected="hello";
		String actual = hc.sayHello();
		
		assertEquals(expected, actual);		

	}
	
	@Test
	public void testAdd() {
		assertEquals(5, hc.add(3, 2));
	}

}
