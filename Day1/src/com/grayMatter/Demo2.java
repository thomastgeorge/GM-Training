package com.grayMatter;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter two number");
		int a= sc.nextInt();
		int b = sc.nextInt();
		System.out.println("Enter the operator");
		char op = sc.next().charAt(0);
		sc.close();
		
		if(op=='+')
			System.out.println(a+b);
		else if(op == '-')
			System.out.println(a-b);
		else if(op == '/')
			System.out.println((float)a/b);
		else if(op == '*')
			System.out.println(a*b);
		else
			System.out.println("invlid operator");
		
	}

}
