package com.singh.ap;

import java.util.Collection;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;


public class Test {

    static Multimap<Integer, String> x = new  HashMultimap();

    public static void main(String[] args) {
    	Multimap<String,  
    	Multimap<String,String>> peoples = new HashMultimap<String,Multimap<String,String>>();  
    	  
    	Multimap<String,String> vehicles = new HashMultimap<String,String>();  
    	vehicles.put("Ferrari", "Silver Ferrari");  
    	vehicles.put("Ferrari", "Red Ferrari");  
    	vehicles.put("Car", "Honda Civic");  
    	vehicles.put("Bycicle", "33 Gears Bycicle");     	
    	peoples.put("Kevin S.", vehicles);    
    	
    	System.out.println(vehicles);
    	System.out.println(peoples);  
    	
    	System.out.println(peoples.get("Kevin S."));
    	Multimap<String,String> f =   (Multimap<String, String>) peoples.get("Kevin S.").toArray()[0];
   
    }
}
