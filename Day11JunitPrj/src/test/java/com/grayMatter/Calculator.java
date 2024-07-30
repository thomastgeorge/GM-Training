package com.grayMatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Calculator {
	
	@Test
	@Category(MarkerInterface.class)
	public void testaculator() {
		assertEquals(9, App.add(5,4));
		assertEquals((Double)5.0, (Double)App.sub(8.0, 3.0));
		assertEquals(2, App.mul(2, 1));
		assertEquals(3, App.div(9, 3));
	}

}
