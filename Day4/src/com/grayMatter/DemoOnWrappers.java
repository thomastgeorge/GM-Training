package com.grayMatter;

public class DemoOnWrappers {
	
	public static void main(String args[]) {
		//primitive to wrapper
		int i=69;
		Integer iObi=i;
		
		//wrapper to primitive
		int j=iObi.intValue();
		
		String sInt = "78";
		int s=Integer.parseInt(sInt);
		
		Integer I=87;
		String S=I.toString();
		
		Float F = 2.2f;
		Double D = 4.4;
		
		Object obj=sInt;	//up casting -> child to parent
		String s1=(String)obj; //down casting -> parent to child(Explicit conversion)
	}

}
