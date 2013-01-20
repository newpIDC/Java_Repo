package com.cert.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.cert.model.Person;

public class ThreadExecuter {
	
	 private int _MAXTHREAD = 5;	 
	 private ExecutorService _execService;
	 private static final ThreadExecuter INSTANCE = new ThreadExecuter();
	 
	  //to prevent creating another instance of Singleton
	  private ThreadExecuter(){			  
	    	 _execService = Executors.newFixedThreadPool(_MAXTHREAD);
	  }

	  private Future<?> startNewThread( Person person ) throws Exception {
	      
		  //_execService.execute(new SampleClient(person));
		
		  //with .submit(T) method, if return value is NUll, then successful  
		  return _execService.submit(new SampleClient(person));
	  }
	  
	
	
	/*public ThreadExecuter(int maxThread){
		 _execService = Executors.newFixedThreadPool(maxThread);
	}*/	
	  
	 public Future<?> postToService(Person person) throws Exception {
	       return startNewThread(person);
	 }
	 
	 private void shutdownExecuter(){
		 if( null != _execService ){
			 _execService.shutdown();
		 }
	 }
	 
	private boolean isTerminated(){		
			return  _execService.isTerminated();		 
	}
	
	public void waitforThreadstoFinish(){
		shutdownExecuter();
		while(!isTerminated()){
			
		}
	}
	
	public static ThreadExecuter getSingleton(){
	    return INSTANCE;
	}	
	
}
