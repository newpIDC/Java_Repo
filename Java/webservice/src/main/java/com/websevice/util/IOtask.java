package com.websevice.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOtask {
	
	public static void readStream(InputStream ioStream) throws IOException{
		//intilize an InputStream
    	//InputStream is = new ByteArrayInputStream("file content".getBytes());
 
    	//read it with BufferedReader
    	BufferedReader br   = new BufferedReader(new InputStreamReader(ioStream)); 
    	StringBuilder sb = new StringBuilder();
 
    	String line;
    	while ((line = br.readLine()) != null) {
    		sb.append(line);
    		
    	} 
 
    	System.out.println(sb.toString());
 
    	br.close();
	}
}
