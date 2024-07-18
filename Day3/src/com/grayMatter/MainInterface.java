package com.grayMatter;

public class MainInterface {

	public static void main(String[] args) {
		
		CalculatorInterface ci = new MyCalculator();
		System.out.println(ci.add(2.3f, 3.2f));
		
		MyScientificCalculator sc = new MyCalculator();
		System.out.println(sc.sqrt(16));

	}

}
