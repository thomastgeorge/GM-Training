package com.grayMatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class DemoOnSets {
	public static void main(String[] args) {
		//no duplicate
		//insertion order is not preserved
		HashSet<Integer> hs = new HashSet<>();
		
		hs.add(56);
		hs.add(26);
		hs.add(14);
		hs.add(7);
		hs.add(96);
		hs.add(13);
		System.out.println(hs);
		hs.add(56);
		hs.add(null);
		System.out.println(hs);
		
		Iterator<Integer> itr = hs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Object arr[]=hs.toArray();
		System.out.println("\nObject");
		for(Object o:arr)
			System.out.println(o);
		
		List<Object> alist=Arrays.asList(arr);
		Collections.reverse(alist);
		System.out.println(alist);
		
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(0);
		ts.add(99);
		ts.add(32);
		ts.add(20);
		ts.add(80);
		ts.add(8);
		ts.add(12);
		System.out.println(ts);
		Iterator<Integer> itr1 = ts.descendingIterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}

        System.out.println("\nCeling "+ts.ceiling(50));
        System.out.println("Floor "+ts.floor(10));
        System.out.println(ts.headSet(14));
        System.out.println(ts.tailSet(14));
		
        Employee e1 = new Employee("User1", 001, 2400000, "Blr");
        Employee e2 = new Employee("User3", 003, 5000000, "Hyd");
        Employee e3 = new Employee("User2", 002, 6000000, "Hyd");
        Employee e4 = new Employee("User4", 004, 30000, "Blr");
        Employee e5 = new Employee("User5", 005, 24000000, "Blr");
        
        TreeSet<Employee> empTree = new TreeSet<Employee>();
        //TreeSet with user defined data type should go with Comparable
        empTree.add(e1);
        empTree.add(e2);
        empTree.add(e3);
        empTree.add(e4);
        empTree.add(e5);
        
        for(Employee e: empTree) {
        	System.out.println(e);
        }
        
	}

}
