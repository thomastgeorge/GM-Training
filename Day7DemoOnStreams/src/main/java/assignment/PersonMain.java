package assignment;

import java.util.HashSet;
import java.util.Set;

public class PersonMain {

	public static void main(String[] args) {
		Set<Person> person = new HashSet<>();
		
		person.add(new Person("varma", 21, "Guntur", "123456789"));
		person.add(new Person("kiran", 22, "Bapatla", "976432334"));
		person.add(new Person("ashok", 32, "vijayawada", "98765434567"));
		person.add(new Person("avinash", 12, "Bangalore", "6345635678"));
		person.add(new Person("likith", 22, "Tirupathi", "4567653456"));
		
		
		person.stream()
	    .forEach(e -> {
	        if (e.getAge() < 18) {
	            System.out.println(e.getName() + " is not eligible for voting."+ new Exception("Age not 18+"));
	        } else {
	            System.out.println(e.getName() + " Eligible for voting.");
	        }
	    });
	}
}
