package com.grayMatter;

public class DemoFunctionalInterface implements FunctionalInterface  {
	
	public static void main(String args[]) {
		
		DemoFunctionalInterface dfi = new DemoFunctionalInterface();
		System.out.println(dfi.cube(5));
		
		FunctionalInterface fi = dfi;
		System.out.println(fi.cube(2));
		
	}

	@Override
	public int cube(int num) {
		// TODO Auto-generated method stub
		return num*num*num;
	}

}
