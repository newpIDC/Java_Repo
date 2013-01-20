package com.thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Copyfile {
	
	void testCopy() throws Exception {
	    ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	    final long start = System.currentTimeMillis();
	    
	    Callable<Object> task = new Callable<Object>() {
	        @Override
	        public Object call() throws Exception {
	            try {
	                copy("a.bin", "b.bin");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            System.out.println("Call really finished after: "
	                    + (System.currentTimeMillis() - start));
	            return null;
	        }
	    };
	    
	    
	    Collection<Callable<Object>> taskWrapper = Arrays.asList(task);
	    
	    List<Future<Object>> futures = exec.invokeAll(taskWrapper, 50, TimeUnit.MILLISECONDS);
	    System.out.println("invokeAll finished after: "
	            + (System.currentTimeMillis() - start));
	    System.out.println("Future.isCancelled? "
	            + futures.get(0).isCancelled());
	    Thread.sleep(20);
	    System.out.println("Threads still active: " + exec.getActiveCount());
	}
	
	private void copy(String in, String out) throws Exception {
	    FileInputStream fin = new FileInputStream(in);
	    FileOutputStream fout = new FileOutputStream(out);
	 
	    byte[] buf = new byte[4096];
	    int read;
	    while ((read = fin.read(buf)) > -1) {
	        fout.write(buf, 0, read);
	    }
	 
	    fin.close();
	    fout.close();
	}
}
