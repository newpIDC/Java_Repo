package com.cert.dao;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

import com.cert.util.ThreadExecuter;

public class CertJobListener {
		
		ThreadExecuter threadExecuter = ThreadExecuter.getSingleton();
		
	 	@BeforeJob
	    public void beforeJob(JobExecution jobExecution) {
	       	 		
	    }
	 
	 	@AfterJob
	    public void afterJob(JobExecution jobExecution) {
	       if( null != threadExecuter){
	 		/*	threadExecuter.shutdownExecuter();
	 		// Wait until all threads are finish
	 			while (!threadExecuter.isTerminated()) {

	 			}*/
	 			threadExecuter.waitforThreadstoFinish();
	 			System.out.println("After job finish.");
	 		}
	    }  
	
}
