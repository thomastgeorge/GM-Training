package com.grayMatter;

import java.util.Arrays;

public class School {

	String schoolName;
	String address;
	ClassRoom cr[];
	
	public School() {
		super();
	}

	public School(String schoolName, String address) {
		super();
		this.schoolName = schoolName;
		this.address = address;
		ClassRoom c1 = new ClassRoom(2,3);
		ClassRoom c2 = new ClassRoom(5,1);
		ClassRoom cr[] = new ClassRoom[2];
		this.cr=cr;
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", address=" + address + ", cr=" + Arrays.toString(cr)
				+  "]";
	}
	
	
}
