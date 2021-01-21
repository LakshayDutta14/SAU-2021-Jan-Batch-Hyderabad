package com.accolite.au.annotations;

import java.io.IOException;
import java.sql.SQLException;


import org.xml.sax.SAXException;


import com.accolite.au.xmlprocessing.Assignments;
import com.accolite.au.xmlprocessing.XMLProcessingExample;
import com.accolite.au.jdbc.JdbcExamples;
public class Annotations implements Runnable {

	public static void main(String[] args) throws SAXException, IOException {
		Annotations annotations = new Annotations();
		
		// functional interface
//		annotations.functionalInterface();
		annotations.customAnnotation();
		         
		XMLProcessingExample.CreateXMLFileJava(); // QUESTION 1 ASSIGNMENT
		System.out.println("Result of Parsing  XML FILE ");
		Assignments ll=XMLProcessingExample.jaxBParser(); // QUESTION 2 ASSIGNMENT
		try {
			JdbcExamples.main(null);                //QUESTION 3 ASSIGNMENT
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Details sucessfully stored in the Database");
	}
	
	@Override
	public void run() {
		// marking method with @Override ensures the we never have a 
		// scenario where sub class doesn't have expected method
	}

	void functionalInterface() {
		MathFunctionalInterface adder = (a, b) -> a + b;
		MathFunctionalInterface multiplier = (a, b) -> a * b;
		System.out.println(adder.operate(2, 3));
		System.out.println(multiplier.operate(2, 3));
	}
	
	void customAnnotation() {
		Vegetable veggie = new Vegetable("Carrot", "Orange");
		try {
			System.out.println(NameChanger.changeNames(veggie));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
