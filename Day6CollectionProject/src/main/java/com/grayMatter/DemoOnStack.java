package com.grayMatter;

import java.util.Stack;

public class DemoOnStack {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(20);
		st.push(90);
		st.push(30);
		st.push(10);
		st.pop();
		st.push(1);
		System.out.println(st);
		st.add(10);
		st.add(2, 2);
		System.out.println(st);
		
		System.out.println(st.capacity());
		st.trimToSize();
		System.out.println(st.capacity());
		st.push(100);
		System.out.println(st.capacity());
		
		
	}

}
