package com.grayMatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoOnStreams {
	public static void main(String[] args) {
		
		Integer arr[] = new Integer[] {11,22,3,64,24,84};
		
		List<Integer> list = Arrays.stream(arr)	//stream generator
		.limit(5)
		.filter(i->i%2==0)
		.map(i->i+10) 	//Intermediate operations
		//.forEach(i-> System.out.println(i) );	//terminal 
		.collect(Collectors.toList());
		
		ArrayList<String> al = new ArrayList<>();
		al.add("abc");
		al.add("user");
		al.add("ambada");
		al.add("sdg");
		al.add("user");
		al.add("bnmbe");
		
		al.stream()
		.distinct()
		.filter(i-> i.endsWith("e"))
		.map(s->s.toUpperCase())
		.forEach(i-> System.out.println(i));
		
		ArrayList<Integer> al1 = new ArrayList<>();
		al1.add(12);
		al1.add(22);
		al1.add(13);
		al1.add(10);
		al1.add(85);
		al1.add(99);
		
		System.out.println(al1.stream()
		.skip(3)
		.reduce(0,(a,b)->a+b));
		
		Integer ar[] = new Integer[] {1,2,3,4,5};
		Arrays.stream(ar)
		.map(e->{
			int f=1;
			for(int j=1; j<=e; j++)
					f*=j;
			return f;
		})
		.forEach(e-> System.out.println(e));
		
		System.out.println(Arrays.stream(ar).mapToInt(i->i).sum());
		System.out.println(Arrays.stream(ar).mapToInt(i->i).max());
		System.out.println(Arrays.stream(ar).mapToInt(i->i).min());
		
		System.out.println("2nd most min value"+ al1.stream().sorted().skip(1).findFirst().get());
		
		System.out.println("2nd most max value"+ al1.stream().sorted().skip(list.size()-2).findFirst().get());
		
		
	}

}
