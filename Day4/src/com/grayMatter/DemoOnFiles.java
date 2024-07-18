package com.grayMatter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DemoOnFiles {
	
	public static void main(String[] args) throws IOException {
		File file=new File("Demo.txt");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		FileWriter fw= new FileWriter(file, true);
		String str="hello world.";
		for(char c:str.toCharArray()) {
			fw.write(c);
		}
		fw.append(str);
		fw.close();
		
		FileReader fr = new FileReader(file);
		char ch;
		StringBuffer sbf=new StringBuffer();
		while((ch=(char)fr.read())!=-1) {
			sbf.append(ch);
		}
		System.out.println(sbf);
		fr.close();
		
	}
	

}
