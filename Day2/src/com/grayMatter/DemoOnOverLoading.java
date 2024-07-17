package com.grayMatter;

public class DemoOnOverLoading {
	
	//change on parameter type
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	
	public void add(float a, float b) {
		System.out.println(a+b);
	}
	
	public void add(String a, String b) {
		System.out.println(a+b);
	}
	
	//change in no.of. parameters
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	public void add(double a, double b, double c, double d) {
		System.out.println(a+b+c+d);
	}
	
	//change on order of parameters
	public void add(int a, double b) {
		System.out.println(a+b);
	}
	
	public void add(double b, int a) {
		System.out.println(a+b);
	}
	
	public void add(Complex c1, Complex c2) {
		Complex c3= new Complex();
		c3.real=c1.real+c2.real;
		c3.img=c1.img+c2.img;
		System.out.println(c3.real+"+i"+c3.img);
	}
	
	public static void main(String[] args) {

		DemoOnOverLoading ol = new DemoOnOverLoading();
		ol.add(12, 12);
		ol.add(12.5f, 12.5f);
		ol.add(4.5, 3.4, 9.1, 10.3);
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(4,5);
		ol.add(c1,c2);

	}

}
