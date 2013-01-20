package com.file.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.server.UID;
import java.util.UUID;



public class Main {
	public static void main(String... arg) throws IOException{
		
		Process proc = null;
		String[] cmd = { "cmd", "/c", "dir" };
		//proc = Runtime.getRuntime().exec(cmd);
		ProcessBuilder pb = new ProcessBuilder(cmd) ;
		proc = pb.start();
		java.io.InputStream inputStream =  proc.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
		    System.out.println(line);
		}
		/* LoggedPrintStream lpsOut = LoggedPrintStream.create(System.out);
	        LoggedPrintStream lpsErr = LoggedPrintStream.create(System.err);

	        // Set them to stdout / stderr
	        System.setOut(lpsOut);
	        System.setErr(lpsErr);

	        // Print some stuff
	        System.out.print("hello ");
	        System.out.println(5);
	        System.out.flush();

	        System.err.println("Some error");
	        System.err.flush();

	        // Restore System.out / System.err
	        System.setOut(lpsOut.underlying);
	        System.setErr(lpsErr.underlying);

	        // Print the logged output
	        System.out.println("----- Log for System.out: -----\n" + lpsOut.buf);
	        System.out.println("----- Log for System.err: -----\n" + lpsErr.buf);
*/		
		/*CountWordsInAString.countWordsInAString();
		String[] english = new String[]{"one", "two", "three"};
        f(english);
        f("uno", "dos", "tres");
        for (int idx=0; idx<10; ++idx){
            UID userId = new UID();
            System.out.println("User Id: " + userId);
          }
        
        UUID idOne = UUID.randomUUID();
        UUID idTwo = UUID.randomUUID();
        log("UUID One: " + idOne);
        log("UUID Two: " + idTwo);*/
	}
	
	 private static void log(Object aObject){
		    System.out.println( String.valueOf(aObject) );
	}
	 
	 public static void f(String... args) {
	        for (String s: args) {
	            System.out.println(s);
	        }
	 }
}
