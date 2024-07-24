package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		//implement a lambda expression to sort stings in alphabetical order
		
		//lambda expression to find the avg of list of doubles
				
		//lambda expression to check num is prime
			
		//Concatenate 2 strings
		
		//Create a person class with name, age, city, aadhar num. create a hashset of n no.of persons
		//and check wheather the person is elligible for casting vote or else throw AgeotElligibleException
		//exception using streams
		
		ArrayList<String> strings =new ArrayList<>();
		strings.add("apple");
		strings.add("orange");
		strings.add("banana");
		strings.add("pineapple");
		strings.add("watermelon");
		
		strings.stream()
		.sorted((s1, s2)->s1.compareToIgnoreCase(s2))
		.forEach(e->System.out.println(e));
		
		
		ArrayList<Double> l =new  ArrayList<>();
		l.add(12.4);
		l.add(32.5);
		l.add(91.7);
		l.add(81.1);
		l.add(22.0);
		
		System.out.println("\n"+l.stream()
		.mapToDouble(Double::doubleValue)
		.average()
		.orElse(0.0));
		
		int[] num = {6, 12, 234, 245, 654, 1, 56, 54, 45};

		
		Predicate<Integer> isPrime = val ->{
			if(val <= 1)
				return false;
			for(int i=2; i<=Math.sqrt(val);i++)
				if(val % i == 0)
					return false;
			return true;
		};
		
		
        for (int temp : num) {
        	if(isPrime.test(temp))
        		System.out.println(temp + " : is a Prime Number");
        	else
        		System.out.println(temp + " : is Not a Prime Number");
        }
        
        String str1 = "test1";
		String str2 = "test2";
		
		String str3 = Stream.concat(Stream.of(str1), Stream.of(str2)).reduce((a,b)->a+b).orElse("UnAble to concat two Strings!!");
		System.out.println(str3);
		
	}

}
