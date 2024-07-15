package com.grayMatter;

public class StudentDriver {

	public static void main(String[] args) {
		Student stud1 = new Student();
		System.out.println(stud1);
		stud1.setStudName("Thoma");
		stud1.setId(1);
		stud1.setM1(91);
		stud1.setM2(98);
		stud1.setM3(100);
		System.out.println(stud1);
		
		System.out.println("using getters");
		System.out.println(stud1.getStudName());
		System.out.println(stud1.getId());
		System.out.println(stud1.getM1());
		System.out.println(stud1.getM2());
		System.out.println(stud1.getM3());
		
	}

}
