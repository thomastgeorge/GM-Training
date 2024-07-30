package com.grayMatter;

/**
 * Hello world!
 *
 */
public class App 
{
	public static String printName(String name) {
		return name;
	}
	
	public static int findKey(int arr[], int key) {
		for(int a : arr) {
			if(a==key)
				return a;
		}
		return -1;
	}
	
	public static int add(int d, int e) {
		return d+e;
	}
	
	public static double sub(double a, double b) {
		return a-b;
	}
	public static int mul(int a, int b) {
		return a*b;
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
