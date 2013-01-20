package com.ibm.jms;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class MQGetPut {
	
	 
	  private String hostname = "localhost";      // define the name of your  
	                                                  // host to connect to  
	  private String channel  = "SYSTEM.DEF.SVRCONN";     // define name of channel  
	                                                  // for client to use  
	                                                  // Note. assumes MQSeries Server  
	                                                  // is listening on the default  
	                                                  // TCP/IP port of 1414  
	  private String qManager = "IBM.QM";     // define name of queue  
	                                                  // manager object to  
	                                                  // connect to.  
	   
	  private MQQueueManager qMgr;                    // define a queue manager object  
	   
	  // When the class is called, this initialization is done first.  
	   
	  @SuppressWarnings("unchecked")
	public void init()  
	  {  
	   /*  // Set up MQSeries environment  
	     MQEnvironment.hostname = hostname;           // Could have put the  
	                                                  // hostname & channel  
	     MQEnvironment.channel  = channel;            // string directly here!  
	   
	     MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,//Set TCP/IP or server  
	                                  MQC.TRANSPORT_MQSERIES);//Connection  
	   */
	  } // end of init  
	   
	  public void start()  
	  {  
	   
	    try {  
	    	 MQEnvironment.hostname = hostname;           // Could have put the  
             // hostname & channel  
	    	 MQEnvironment.channel  = channel;            // string directly here!  
	    	 MQEnvironment.port = 1414;
	    	 MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,//Set TCP/IP or server  
	    	 						MQC.TRANSPORT_MQSERIES);//Connection  
	    	
	      // Create a connection to the queue manager  
	      qMgr = new MQQueueManager(qManager);  
	   
	      // Set up the options on the queue we wish to open...  
	      // Note. All MQSeries Options are prefixed with MQC in Java.  
	   
	      @SuppressWarnings("deprecation")
		int openOptions = MQC.MQOO_INPUT_AS_Q_DEF |  
	                        MQC.MQOO_OUTPUT ;  
	   
	      // Now specify the queue that we wish to open, and the open options...  
	   
	      MQQueue system_default_local_queue =  
	              qMgr.accessQueue("Q1",  
	                               openOptions,  
	                               null,           // default q manager  
	                               null,           // no dynamic q name  
	                               null);          // no alternate user id  
	   
	      // Define a simple MQSeries message, and write some text in UTF format..  
	   
	      MQMessage hello_world = new MQMessage();  
	      hello_world.writeUTF("Hello World!");  
	   
	      // specify the message options...  
	   
	      MQPutMessageOptions pmo = new MQPutMessageOptions();  // accept the defaults,  
	                                                            // same as  
	                                                            // MQPMO_DEFAULT  
	                                            // constant  
	   
	      // put the message on the queue  
	   
	      system_default_local_queue.put(hello_world,pmo);  
	   
	      // get the message back again...  
	      // First define a MQSeries message buffer to receive the message into..  
	   
	      MQMessage retrievedMessage = new MQMessage();  
	      retrievedMessage.messageId = hello_world.messageId;  
	   
	      // Set the get message options..  
	   
	      MQGetMessageOptions gmo = new MQGetMessageOptions();  // accept the defaults  
	                                                            // same as  
	                                                            // MQGMO_DEFAULT  
	   
	      // get the message off the queue..  
	   
	      system_default_local_queue.get(retrievedMessage, gmo);  
	   
	      // And prove we have the message by displaying the UTF message text  
	   
	      String msgText = retrievedMessage.readUTF();  
	      System.out.println("The message is: " + msgText);  
	   
	      // Close the queue  
	   
	      system_default_local_queue.close();  
	   
	      // Disconnect from the queue manager  
	   
	      qMgr.disconnect();  
	   
	    }  
	   
	    // If an error has occurred in the above, try to identify what went wrong.  
	    // Was it an MQSeries error?  
	   
	    catch (MQException ex)  
	    {  
	      System.out.println("An MQSeries error occurred : Completion code " +  
	                         ex.completionCode +  
	                         " Reason code " + ex.reasonCode);  
	    }  
	    // Was it a Java buffer space error?  
	    catch (java.io.IOException ex)  
	    {  
	      System.out.println("An error occurred whilst writing to the  message buffer: " + ex);  
	    }  
	   
	  } // end of start  
}
