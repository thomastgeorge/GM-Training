package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count {
	
	public static void main(String[] args) throws IOException {
		String str = "Hello World, this text is written to file and read from the from";
		FileOutputStream fos = new FileOutputStream("work.txt");
		fos.write(str.getBytes());
		fos.close();
		
		long charCount = 0;
	    long wordCount = 0;
	    long lineCount = 0;
	        
	    FileInputStream fis = new FileInputStream("work.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

	        try {

	            String line;
	            while ((line = br.readLine()) != null) {
	                lineCount++;

	                // Count characters
	                charCount += line.length();

	                // Count words
	                String[] words = line.trim().split("\\s+");
	                wordCount += words.length;
	            }
	        }
	        finally {
	        	
	        }
	        
	        br.close();
	        fis.close();
	        isr.close();
	        System.out.println("Character count: " + charCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Line count: " + lineCount);
            
            File file = new File("work.txt");
            String s= br.toString();
            String modifiedContent = replaceCharacter(s, 's', '*');
            writeToFile(file, modifiedContent);

            System.out.println("Modified content written to the file.");
	}
	
    	public static void writeToFile(File file, String data) {
    		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
    				bw.write(data);
            System.out.println("Data successfully written to the file.");
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}

    
    	public static String replaceCharacter(String content, char oldChar, char newChar) {
    		return content.replace(oldChar, newChar);
    	}

}
