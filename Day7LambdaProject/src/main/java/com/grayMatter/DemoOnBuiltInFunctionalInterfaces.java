package com.grayMatter;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoOnBuiltInFunctionalInterfaces {
	public static void main(String[] args) {
		
		Consumer<Integer> consumer=(i)->System.out.println(i);
		consumer.accept(89);
		
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(12);
		alist.add(53);
		alist.add(4);
		alist.add(35);
		alist.add(20);
		alist.add(5);
		alist.add(8);
		alist.forEach(consumer);
		
		Supplier<String> supplier=()->"hello";
		System.out.println(supplier.get());
		
		Predicate<Integer> predicate=(num)->num%2==0;
		
		int arr[]= {14,23,56,77,89,12};
		for(int i: arr)
			if(predicate.test(i))
				System.out.println(i);
		
		Function<Integer, Integer> function=(num)->{
			int fact=1;
			for(int i=1; i<=num; i++)
				fact+=i;
			return fact;			
		};
		System.out.println("\nFunction "+ function.apply(5));
		
	}

}
