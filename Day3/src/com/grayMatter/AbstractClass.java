package com.grayMatter;

public abstract class AbstractClass {
	
	@SuppressWarnings("unused")
	private String name;
	
	public abstract void sayHello();
	
	public void printName(String name) {
		this.name=name;
		System.out.println("name: "+name);
	}

}
