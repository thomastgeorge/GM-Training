package com.grayMatter;

import java.io.Serializable; //to convert object data to file stream and vice versa

public class ObjectStream implements Serializable {
	
	private String name;
	private int id;
	
	public ObjectStream() {
		super();
	}
	
	public ObjectStream(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ObjectStream [name=" + name + ", id=" + id + "]";
	}
	
	

}
