package com.grayMatter;

public class DemoClass {

	public String name;
	public void printName() {
		System.out.println("name: "+name);
		InnerClass ic = new InnerClass();
		ic.innerClassName="Inner Class";
		System.out.println("InnerClass: "+ic.innerClassName);
	}
	
	public class InnerClass{
		 String innerClassName;
	}
	

}
