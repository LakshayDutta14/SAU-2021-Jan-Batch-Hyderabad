package assignment;

import java.util.HashMap;
import java.util.Iterator;

public class Individualwordsthread extends Thread {

	
	
	
	private HashMap<String, Integer> mp1=new HashMap<String,Integer>();

	public Individualwordsthread(HashMap<String, Integer> mp) {
		this.mp1=mp;
	}

	@Override
	public void run()
	{
		Iterator<String> itr = mp1.keySet().iterator();
		while (itr.hasNext()) {
			String a1=itr.next();
		    System.out.println(a1+" "+mp1.get(a1));
		 
		}
	}
}
