package com.grayMatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class DemoOnLinkedList {

	public static void main(String[] args) {
		LinkedList<String> fruits=new LinkedList<String>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("orange");
		
		for(String s: fruits)
			System.out.println(s);
		
		fruits.addFirst("mango");
		fruits.addLast("waterMelom");
		fruits.add("orange");
		//fruits.add(null);
		System.out.println(fruits);
		
		Iterator<String> itr = fruits.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		fruits.add(2, "pineapple");
		
		Collections.sort(fruits);
		System.out.println(fruits);
		
		System.out.println(fruits.contains("apple"));
		
		LinkedList<String> myFruits = (LinkedList<String>) fruits.clone();
		System.out.println(myFruits);
		
		System.out.println(fruits.hashCode());
		System.out.println(myFruits.hashCode());
		
		fruits.add("pineapple");
		
		System.out.println(fruits.hashCode());
		System.out.println(myFruits.hashCode());
		
		LinkedList<Employee> empList = new LinkedList<Employee>();
        Employee e1 = new Employee("User1", 001, 2400000, "Blr");
        Employee e2 = new Employee("User3", 003, 5000000, "Hyd");
        Employee e3 = new Employee("User2", 002, 6000000, "Hyd");
        Employee e4 = new Employee("User4", 004, 24000000, "Blr");
        Employee e5 = new Employee("User5", 005, 24000000, "Blr");
        
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);
        
        LinkedList<Employee> myEmps = (LinkedList<Employee>) empList.clone();
        System.out.println(empList.hashCode());
		System.out.println(myEmps.hashCode());
		
		Employee e6 = new Employee("User6", 065, 9900000, "Blr");
		myEmps.add(e6);
		System.out.println(myEmps+"\n");
		
		LinkedList<Item> i = new LinkedList<Item>();
		Item i1= new Item("Fruits", 101, 234, "Wallmart");
		Item i2= new Item("Shoes", 10000, 4135, "Nike");
		Item i3= new Item("Shirts", 1001, 1230, "Zara");
		Item i4= new Item("Laptops", 500, 68900, "Lenovo");
		Item i5= new Item("Pants", 1001, 890, "Zara");
		Item i6= new Item("Shirts", 1001, 1230, "Nike");
		
		i.add(i1);
		i.add(i2);
		i.add(i3);
		i.add(i4);
		i.add(i5);
		i.add(i6);
		
		i.sort(new ItemNameComparator()
				.thenComparing(new BrandComparator()));
		
		for(Item temp:i) {
			System.out.println(temp);
		}
	}
}
