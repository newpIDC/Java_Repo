package com.ibm.jms;

/*
 * <N_OCO_COPYRIGHT>
 * Licensed Materials - Property of IBM
 * 
 * 5724-H72, 5655-R36, 5724-L26, 5655-L82     
 * 
 * (c) Copyright IBM Corp. 1995, 2009 All Rights Reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with
 * IBM Corp.
 * <NOC_COPYRIGHT>
 */

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

/**
 * Simple example program
 */
public class MQSample {

  // code identifier
  static final String sccsid = "@(#) samples/wmqjava/MQSample.java, jmscc.samples, k710, k710-002-120928 1.8.2.1 11/10/17 15:54:39";

  // define the name of the QueueManager
  private static final String qManager = "IBM.QM";
  // and define the name of the Queue
  private static final String qName = "Q1";

  /**
   * Main entry point
   * 
   * @param args - command line arguments (ignored)
   */
  public static void putGet(String args[]) {
    try {
   
   	 MQEnvironment.hostname = "localhost";           // Could have put the  
     // hostname & channel  
	 MQEnvironment.channel  = "SYSTEM.DEF.SVRCONN";            // string directly here!  
	 MQEnvironment.port = 1414;
	 //MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,//Set TCP/IP or server  
	 //						MQC.TRANSPORT_MQSERIES);//Connection  
    	
	 MQEnvironment.properties.put(MQConstants.TRANSPORT_PROPERTY,//Set TCP/IP or server  
			 					MQConstants.TRANSPORT_MQSERIES);//Connection 	
    	// Create a connection to the QueueManager
   
	  System.out.println("Connecting to queue manager: " + qManager);
      MQQueueManager qMgr = new MQQueueManager(qManager);

      // Set up the options on the queue we wish to open
      int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;

      // Now specify the queue that we wish to open and the open options
      System.out.println("Accessing queue: " + qName);
      MQQueue queue = qMgr.accessQueue(qName, openOptions);

      // Define a simple WebSphere MQ Message ...
      MQMessage msg = new MQMessage();
      // ... and write some text in UTF8 format
      msg.writeUTF("Hello, World!");

      // Specify the default put message options
      MQPutMessageOptions pmo = new MQPutMessageOptions();

      // Put the message to the queue
      System.out.println("Sending a message...");
      queue.put(msg, pmo);

      // Now get the message back again. First define a WebSphere MQ
      // message
      // to receive the data
      MQMessage rcvMessage = new MQMessage();
      rcvMessage.messageId = msg.messageId;

      // Specify default get message options
      MQGetMessageOptions gmo = new MQGetMessageOptions();

      // Get the message off the queue.
      System.out.println("...and getting the message back again");
      queue.get(rcvMessage, gmo);

      // And display the message text...
      String msgText = rcvMessage.readUTF();
      System.out.println("The message is: " + msgText);

      // Close the queue
      System.out.println("Closing the queue");
      queue.close();

      // Disconnect from the QueueManager
      System.out.println("Disconnecting from the Queue Manager");
      qMgr.disconnect();
      System.out.println("Done!");
    }
    catch (MQException ex) {
      System.out.println("A WebSphere MQ Error occured : Completion Code " + ex.completionCode
          + " Reason Code " + ex.reasonCode);
      ex.printStackTrace();
      for (Throwable t = ex.getCause(); t != null; t = t.getCause()) {
        System.out.println("... Caused by ");
        t.printStackTrace();
      }

    }
    catch (java.io.IOException ex) {
      System.out.println("An IOException occured whilst writing to the message buffer: " + ex);
    }
    return;
  }
}

