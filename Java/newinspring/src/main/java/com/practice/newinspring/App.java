package com.practice.newinspring;

import org.springmodules.validation.valang.functions.EmailFunction;
import org.springmodules.validation.valang.functions.Function;
public class App 
{
    public static void main( String... args )  {
    	Function[] arguments = null;
		EmailFunction fun = new EmailFunction( arguments, 2, 5);
    	 System.out.println( "Hello World!" );
    }
}
