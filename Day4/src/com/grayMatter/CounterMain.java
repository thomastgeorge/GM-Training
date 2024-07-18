package com.grayMatter;

public class CounterMain extends Thread {
	CounterClass c;

	public CounterMain() {
		super();
	}

	public CounterMain(CounterClass c) {
		super();
		this.c = c;
	}

	@Override
	public void run() {
		for(int i =0; i<=10; i++) {
			c.updateCounter();
			try{
				sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		CounterClass cc=new CounterClass();
		CounterMain cm1=new CounterMain(cc);
		CounterMain cm2=new CounterMain(cc);
		
		cm1.start();
		cm2.start();
		
		System.out.println(cc.getCount());

	}

}
