package com.accolite.example;

public class FlyweightDemo {
	
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };
	   public static void main(String[] args) {

	      for(int i=0; i < colors.length; ++i) {
	         Square circle = (Square)ShapeFactory.getCircle(colors[i]);
	        
	         circle.setSide(100);
	         circle.draw();
	      }
	   }
	  
	}


