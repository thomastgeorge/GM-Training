package com.grayMatter;

public class Demo1 {

	public static void main(String[] args) {
		
		int num = 5;
		System.out.println("num = "+num);
		int num1=8, num2=3;
		System.out.println("valued "+num1+num2);
		System.out.println("sum = "+ (num1+num2));
		System.out.println("div = "+ (num1/num2));
		System.out.println("div = "+ ((float)num1/num2));
		
		int a=45, b=37, c=21;
		System.out.println(a>b?(a>c?a:c):(b>c?b:c));
		
		//TODO max of 4 & 5 number using ternary operator
		
		//swapping 3 number
		a=a+b+c;
		b=a-b-c;
		c=a-b-c;
		a=a-b-c;
		
		int i=5, j=3;
		
		System.out.println(i&j);
		System.out.println(i|j);
		
		//Right Shift
		System.out.println(60>>3);
		System.out.println(-60>>3);
		
		
		
	}

}
