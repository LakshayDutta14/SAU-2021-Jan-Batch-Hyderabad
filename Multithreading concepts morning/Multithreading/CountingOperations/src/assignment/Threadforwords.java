package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Threadforwords extends Thread{
	Threadforwords(){
		
	}
	@Override
	public void run() {
		try {
			 String str;  
		        int count = 0;  
		        FileReader file = new FileReader("src/Book.txt");  
		        BufferedReader br = new BufferedReader(file);  
		        while((str = br.readLine()) != null) {  
		             
		            String words[] = str.split(" ");  
		            
		            count = count + words.length;  
		        }  
		          
		        System.out.println("Number of words present in given file using thread are " + count);  
		        br.close(); 
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
	}

}