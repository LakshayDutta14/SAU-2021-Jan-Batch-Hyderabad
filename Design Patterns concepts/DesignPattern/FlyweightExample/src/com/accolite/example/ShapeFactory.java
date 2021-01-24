package com.accolite.example;

import java.util.HashMap;

public class ShapeFactory {
	 private static final HashMap<String,Square> squareMap = new HashMap<String,Square>();

	   public static Shape getCircle(String color) {
	     Square sq = (Square)squareMap.get(color);

	      if(sq == null) {
	         sq = new Square(color);
	         squareMap.put(color, sq);
	         System.out.println("Creating Square of color : " + color);
	      }
	      return sq;
	   }

}
