package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.enu.Mesages.*;
public class Main {
	
	private static final int NTHREDS = 10;
	
	public static void main(String... arg) throws Exception{
	
		//System.out.println(DUPLICATE_USER);
		//System.out.println(DATABASE);
		Copyfile obj = new Copyfile();
		obj.testCopy();
	//	SchExecutorService SchExecutorServiceobj = new SchExecutorService();
		//SchExecutorServiceobj.beepForAnHour();
	
		// Check the number of available processors
		/*int nThreads = Runtime.getRuntime().availableProcessors();
		System.out.println("No. of processors available :" + nThreads);
		
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new MyRunnable(10000000L + i);
			executor.execute(worker);
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {

		}
		System.out.println("Finished all threads");
*/	}

}
