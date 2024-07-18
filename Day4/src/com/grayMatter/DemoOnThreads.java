package com.grayMatter;

public class DemoOnThreads extends Thread {

	@Override
	public void run() {
		System.out.println("inside run method");
		System.out.println(currentThread().getName());
		System.out.println(currentThread().getId());
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println(currentThread().getName());
		System.out.println(currentThread().getId());
		System.out.println(currentThread().getPriority());
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(currentThread().isDaemon()); //Daemon -> running in background 
		
		DemoOnThreads dot1=new DemoOnThreads();
		dot1.start();
		
		DemoOnThreads dot2=new DemoOnThreads();
		dot2.start();
	}

}
