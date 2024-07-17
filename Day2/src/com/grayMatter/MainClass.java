package com.grayMatter;

public class MainClass {

	public static void main(String[] args) throws Throwable {
		
		School sc = new School("ABC", "abcd");
		
		Student s1 = new Student("abc",33);
		Student s2 = new Student("fgh",11);
		Student s3 = new Student("tyu",66);
		Student st[] = {s1, s2, s3};
		
		ClassRoom c = new ClassRoom(7,4,st);
		
		System.out.println(st);
		
		System.out.println(c);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		MainClass mc=new MainClass();
		mc.finalize();
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("Manual invoke to finalize");
		System.gc();
	}

}
