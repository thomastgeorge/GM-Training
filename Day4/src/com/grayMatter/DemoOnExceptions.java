package com.grayMatter;

public class DemoOnExceptions {

	public static void main(String[] args) {
		
		int a=7,b=0;
		
		try {
			System.out.println(a/b);
		}
		catch(ArithmeticException  | ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ghj");
		}
		finally {
			//used to close the resources, connections
			System.out.println("Excption Finally...");
		}
		
		System.out.println("Complete");
	}

}
