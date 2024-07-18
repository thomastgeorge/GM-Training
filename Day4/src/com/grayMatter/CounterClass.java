package com.grayMatter;

public class CounterClass {
	
	private int  count=0;
	
	public void updateCounter() {
		synchronized (this) {
			count++;
			System.out.println(getCount());
		}
	}

	public int getCount() {
		return count;
	}	

}
