package com.grayMatter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamMain {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectStream os =new ObjectStream("user",12);
		FileOutputStream fos=new FileOutputStream("obj.txt");	//Write
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(os);
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("obj.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ObjectStream os1 = (ObjectStream)ois.readObject();
		System.out.println(os1);
		
		
		
	}

}
