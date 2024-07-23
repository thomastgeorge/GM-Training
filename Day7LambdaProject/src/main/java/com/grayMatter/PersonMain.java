package com.grayMatter;

import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

public class PersonMain {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		
		people.add(new Person("Alice", new Date(90, 0, 1), 30));
	    people.add(new Person("Bob", new Date(80, 5, 15), 45));
	    people.add(new Person("Anna", new Date(70, 8, 25), 50));
	    people.add(new Person("Andrew", new Date(65, 3, 10), 25));
	    people.add(new Person("Alex", new Date(85, 11, 5), 38));
	    
	    Predicate<Person> predicate = person -> {
	        return person.getAge() > 35 && (person.getName().startsWith("A") || person.getName().startsWith("a"));
	    };

	    
	    people.forEach(e->{
	    	if(predicate.test(e))
	    		System.out.println(e);
	    });
	}

}
