package com.grayMatter;

public class DemoOnAccessModifiers {
	
	public static void main(String args[]) {
		
		DemoClass dm = new DemoClass();
		dm.name="Thomaaa";
		dm.printName();
		
		DemoClass.InnerClass ic = new DemoClass().new InnerClass();
		ic.innerClassName="Inner Class Name";

	}

}
