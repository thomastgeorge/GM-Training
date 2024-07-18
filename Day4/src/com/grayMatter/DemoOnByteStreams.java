package com.grayMatter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoOnByteStreams {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("data.txt");
		String s ="Welcome!!";
		fos.write(s.getBytes());
		fos.close();
		
		FileInputStream fis=new FileInputStream("data.txt");
		StringBuffer sb=new StringBuffer();
		int ch;
		while((ch=fis.read())!=-1) {
			sb.append((char)ch);
		}
		System.out.println(sb);
		fis.close();

	}

}
