package com.grayMatter;

import java.util.Arrays;

public class ClassRoom {
	
	int classNumber;
	int floor;
	Student st[];
	
	
	public ClassRoom() {
		super();
	}


	public ClassRoom(int classNumber, int floor, Student st[]) {
		super();
		this.classNumber = classNumber;
		this.floor = floor;
		this.st=st;
	}


	public ClassRoom(int classNumber, int floor) {
		super();
		this.classNumber = classNumber;
		this.floor = floor;
	}


	@Override
	public String toString() {
		return "ClassRoom [classNumber=" + classNumber + ", floor=" + floor + ", st=" + Arrays.toString(st)
				+  "]";
	}
	
	
	
	

}
