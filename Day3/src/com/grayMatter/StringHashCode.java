package com.grayMatter;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringHashCode {

	public static void main(String[] args) {
		
		String a=new String("hello");
		String b=new String("hello");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		b="hi";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		String c=b;
		c=c+" welcome";
		System.out.println(c.hashCode());
		System.out.println(c);
		
		System.out.println(c.equals(a));
		
		System.out.println(c.length());
		
		String d="		hi		";
		System.out.println(d.trim().length());
		d=d.trim();
		d=d.replace('h', 'o');
		System.out.println(d);

		System.out.println(b.compareTo(a));
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.hashCode());
		sb.append("user");
		System.out.println(sb.hashCode());
		String s=sb.toString();
		System.out.println(s.hashCode());
		
		String str[]=new String[3];
		str[0]="hi";
		str[1]="hello";
		str[2]="welcome";
		
		int count=0;
		
		for(String tempS:str) {
			if(tempS.startsWith("h")) {
				count++;
			}
		}
		System.out.println(count);
		
		String para = "Hi hello welcome GoodBye Katham!!";
		String arr[] = para.split(" ");
		System.out.println(Arrays.toString(arr));
		
		StringTokenizer tokenizer = new StringTokenizer(para, " ");
		while(tokenizer.hasMoreTokens())
			System.out.println(tokenizer.nextToken());
		
		StringJoiner sJoiner = new StringJoiner(", ");
		sJoiner.add("apple");
		sJoiner.add("Orange");
		System.out.println(sJoiner.toString());
	
	}

}
