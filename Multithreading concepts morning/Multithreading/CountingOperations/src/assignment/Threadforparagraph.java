package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Threadforparagraph extends Thread {
	@Override
	public void run() {
		try {
		String str; 
		int pCount=0;
		BufferedReader reader = new BufferedReader(new FileReader("src/Book.txt"));
		while((str = reader.readLine()) != null) 
	    { 
	        if(str.equals("")) 
	        { 
	            pCount++; 
	        }  
	    } 
		System.out.println("Number of paragraphs using threads are " + pCount);
		}catch (FileNotFoundException e) {
		      
		      e.printStackTrace();
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
	}

}
