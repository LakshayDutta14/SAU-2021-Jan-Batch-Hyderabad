package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Countofsentence {
	public void scount() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/Book.txt"));
		int sentenceCount = 0;
		String line;
		String delimiters = "?!.";

		while ((line = reader.readLine()) != null) { 
		    for (int i = 0; i < line.length(); i++) {
		        if (delimiters.indexOf(line.charAt(i)) != -1)
		        { 
		            sentenceCount++;
		        }
		    }
		}

		reader.close();
		System.out.println("The number of sentences is " + sentenceCount);
	}
}