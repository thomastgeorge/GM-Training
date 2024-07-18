package com.grayMatter;

public class AgeMain {

	public static void main(String[] args) throws AgeNotSufficientException {

		Person p =new Person("user",2345678, 19);
		
		if(p.getAge()<18) {
			throw new AgeNotSufficientException("peron age need to be atleast 18");
		}
		
		System.out.println("Vote casted..");
		System.out.println(p);

	}

}
