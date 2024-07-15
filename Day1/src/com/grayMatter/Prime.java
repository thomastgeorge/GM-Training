package com.grayMatter;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int a = sc.nextInt();
		sc.close();
		
		int i=2;
		boolean flag = true;
		while(i<=Math.sqrt(a)) {
			if(a%i == 0) {
				flag=!flag;
				break;
			}
			i++;
		}
		
		if(flag)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");

	}

}
