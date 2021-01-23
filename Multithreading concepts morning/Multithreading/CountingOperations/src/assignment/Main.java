package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
	    Countofwords wordcount =new Countofwords();
	    wordcount.wcmethod();
	    
	    Threadforwords wt=new Threadforwords();
		wt.start();
		
		
		HashMap<String,Integer>mp=new HashMap<String,Integer>();
		BufferedReader file = new BufferedReader(new FileReader("src/Book.txt")); 
		String str; 
		while ((str = file.readLine()) != null) {
			String a[]=str.split(" ");
			for(int i=0;i<a.length;i++)
			{
				if(mp.containsKey(a[i].toLowerCase()))
				{
					mp.put(a[i].toLowerCase(),mp.get(a[i].toLowerCase())+1);
				}
				else
				{
					mp.put(a[i].toLowerCase(), 1);
				}
			}	
		}
		Individualwordsthread t=new Individualwordsthread(mp);

		Thread t1= new Thread(t);
		//t1.start(); //uncomment this for viewing count of each word
		
		new Countofsentence().scount();
	    new Countofparagraphs().pcount();
		ThreadforSentence st=new ThreadforSentence();
		st.start();
		Threadforparagraph pt=new Threadforparagraph();
		pt.start();
		
	}

}
