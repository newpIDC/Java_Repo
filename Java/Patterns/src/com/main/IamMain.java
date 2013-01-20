package com.main;

import com.pattern.singleton.*;
public class IamMain {
	public static void main(String[] arg){
		Elvis.INSTANCE.printFavorites();
		
		double x = 89.99;
		double y = 45.50;
		
		for (Operation op : Operation.values()){
			System.out.printf("%f %s %f = %f%n",
			x, op, y, op.apply(x, y));
		}
		
		System.out.println(Ensemble.OCTET.numberOfMusicians());
	}
	
}
