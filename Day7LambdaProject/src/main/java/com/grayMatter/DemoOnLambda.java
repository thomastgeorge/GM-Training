package com.grayMatter;

//Single Abstract related interface is known as Functional Interface
//Lambda is anonymous expression, no objet expected, similar to inline function

@FunctionalInterface
interface HelloInterface{
	public String sayHello();
}

interface NameInterface{
	public void printName(String name);
}

interface AdditionInterface{
	public int add(int a, int b);
}

interface DisplayInterface{
	public void display();
}

public class DemoOnLambda{
	public static void main(String[] args) {
		//No para, with return
		HelloInterface hi =()-> "Hello";
		System.out.println(hi.sayHello());
		
		//with para, no return
		NameInterface ni = (name)->System.out.println(name);
		ni.printName("User");
		
		//with para, with return
		AdditionInterface ai =(a,b)->a+b;
		System.out.println(ai.add(12, 12));
		
		//no para, no return
		DisplayInterface di = ()->System.out.println("Display");
		di.display();
		
	}

	

}
