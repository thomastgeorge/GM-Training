package com.grayMatter;

import java.util.ArrayList;
import java.util.Collection;

public class App<T> 
{
	
	public T add(T a,T b) {
		if(a instanceof Integer)
			return(T)(Integer)((Integer)a+(Integer)b);
		else if(a instanceof String)
			return (T)(String)((String)a+(String)b);
		else
			return null;
		
	}
	
	public static <T> void printDetails (Collection <T> collection) {
		for(T e : collection) {
			System.out.println(e);
		}
	}
    public static void main( String[] args )
    {
    	App<Integer> dgInt =new App();
    	System.out.println(dgInt.add(5,4));
    	
    	App<String> dgStr = new App();
    	System.out.println(dgStr.add("Hell0 ", "World")+"\n");
    	
    	ArrayList<String> alist = new ArrayList<String>();
    	alist.add("hi");
    	alist.add("hello");
    	alist.add("hellooooo");
    	printDetails(alist);
    	
    	ArrayList<Integer> aInt = new ArrayList<Integer>();
    	aInt.add(12);
    	aInt.add(2);
    	aInt.add(55);
    	printDetails(aInt);
    			
    }
}
