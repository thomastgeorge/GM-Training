package com.grayMatter;

public class Static {
	
	public static  void print(){
		System.out.println("Inside print method");
	}

	static {
		System.out.println("static block 1");
	}
	
	static {
		System.out.println("static block 2");
	}
	
	public static void main(String[] args) {
		System.out.println("Inside main");
		print();
	}
	
	static {
		System.out.println("static block 3");
	}
}
