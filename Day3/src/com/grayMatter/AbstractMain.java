package com.grayMatter;

public class AbstractMain {

	public static void main(String[] args) {

		ArithemeticCalculator ac = new ScientificCalculator();
		System.out.println(ac.add(1.2f, 3.5f));
		System.out.println(ac.pow(1.2f, 3.5f));
		
		AbstractCalculator c = new ScientificCalculator();
		System.out.println(c.sqrt(1.2f));	

	}

}
