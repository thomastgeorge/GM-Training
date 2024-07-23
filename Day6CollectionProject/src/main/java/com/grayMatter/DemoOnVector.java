package com.grayMatter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class DemoOnVector {
	public static void main(String[] args) {
		//It is resizable;
		//I is Legacy class
		//Initial size is 10
		//If vector capacity gets exhausted then capacity becomes double
		Vector<Integer> vector = new Vector<Integer>();
		
		System.out.println(vector.capacity());
		for (int i=0; i<10; i++) {
			vector.add(i);
		}
		System.out.println(vector.capacity());
		vector.add(11);
		System.out.println(vector.capacity());
		
		Enumeration<Integer> myEnum = vector.elements();
		while(myEnum.hasMoreElements())
			System.out.println(myEnum.nextElement());
		
		Iterator<Integer> itr = vector.iterator();
		while(itr.hasNext()) {
			int i = itr.next();
			if(i==6)
				itr.remove();
			System.out.println(i);
		}
		System.out.println(vector);
		
		System.out.println(vector.contains(6));
		System.out.println(vector.size());
		//System.out.println(vector.sort());
		
		System.out.println(vector.lastElement());
		System.out.println(vector.lastIndexOf(2, 8));
		
	}

}
