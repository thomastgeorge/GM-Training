package com.grayMatter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DemoOnMap {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(11, "User");
		map.put(9, "Adi");
		map.put(12, "Pwoli");
		map.put(99, "Takida");
		System.out.println(map);
		System.out.println(map.get(12));
		System.out.println(map.keySet());
		map.put(null, "hj");
		System.out.println(map);
		
		Set<Entry<Integer, String>> entSet=map.entrySet();
		Iterator<Entry<Integer, String>> itr = entSet.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
		
		map.forEach((k,v)->System.out.println(k+" "+v));
		
		Employee e6 = new Employee("User5", 005, 24000000, "Blr");
		Employee e1 = new Employee("User1", 001, 2400000, "Blr");
        Employee e3 = new Employee("User3", 003, 5000000, "Hyd");
        Employee e2 = new Employee("User2", 002, 6000000, "Hyd");
        Employee e4 = new Employee("User4", 004, 24000000, "Blr");
        Employee e5 = new Employee("User5", 005, 24000000, "Blr");
        
        TreeMap<Integer, Employee> treeMap= new TreeMap<>();
        treeMap.put(1, e1);
        treeMap.put(4, e4);
        treeMap.put(3, e3);
        treeMap.put(2, e2);
        treeMap.put(5, e5);
        
        for(Entry<Integer, Employee> e: treeMap.entrySet())
        	System.out.println(e);
        
        Address addr=new Address("Blr", "Karnataka");
        TreeMap<Employee, Address> myMap=new TreeMap<>();
        myMap.put(e4, addr);
        myMap.put(e2,  addr);
        myMap.put(e6, addr);
        
        System.out.println(myMap);
	}

}
