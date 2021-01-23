package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Countofparagraphs {
	public void pcount() throws IOException {
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
		System.out.println("Total number of paragraphs are " + pCount);
	}

}