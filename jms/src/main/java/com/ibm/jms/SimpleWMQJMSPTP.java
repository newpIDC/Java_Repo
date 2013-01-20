package com.ibm.jms;

//SCCSID "@(#) samples/jms/simple/SimpleWMQJMSPTP.java, jmscc.samples, k710, k710-002-120928  1.6.2.1 11/10/17 15:54:06"
/*
* <N_OCO_COPYRIGHT>
* Licensed Materials - Property of IBM
* 
* 5724-H72, 5655-R36, 5724-L26, 5655-L82     
* 
* (c) Copyright IBM Corp. 2008, 2009 All Rights Reserved.
* 
* US Government Users Restricted Rights - Use, duplication or
* disclosure restricted by GSA ADP Schedule Contract with
* IBM Corp.
* <NOC_COPYRIGHT>
*/


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;
import com.ibm.mq.jms.MQTopicConnection;
import com.ibm.mq.jms.MQTopicConnectionFactory;

/**
* A minimal and simple application for Point-to-point messaging.
* 
* Application makes use of fixed literals, any customisations will require re-compilation of this
* source file. Application assumes that the named queue is empty prior to a run.
* 
* Notes:
* 
* API type: IBM WebSphere MQ JMS API (v1.02, domain specific)
* 
* Messaging domain: Point-to-point
* 
* Provider type: WebSphere MQ
* 
* Connection mode: Client connection
* 
* JNDI in use: No
* 
*/
public class SimpleWMQJMSPTP {

// System exit status value (assume unset value to be 1)
private static int status = 1;

/**
 * Main method
 * 
 * @param args
 */
public static void main(String[] args) {

  // Variables
  MQQueueConnection  connection = null;
  MQQueueSession session = null;
  MQQueue queue = null;
  MQQueueSender sender = null;
  MQQueueReceiver receiver = null;

  try {
    // Create a connection factory
	  MQQueueConnectionFactory cf = new MQQueueConnectionFactory();

    // Set the properties
	// Config
      cf.setHostName("localhost");
      cf.setPort(1414);
      cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
      cf.setQueueManager("IBM.QM");
      cf.setChannel("SYSTEM.DEF.SVRCONN");
      
    // Create JMS objects
    connection = (MQQueueConnection) cf.createQueueConnection();
    session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    queue = (MQQueue) session.createQueue("queue:///Q1");
    sender = (MQQueueSender) session.createSender(queue);
    receiver = (MQQueueReceiver) session.createReceiver(queue);

    long uniqueNumber = System.currentTimeMillis() % 1000;
    int noMsg = 0;
    
    
    while( noMsg < 100){
    	
    	 TextMessage message = session
         .createTextMessage("SimpleWMQJMSPTP: Your lucky number today is " + uniqueNumber);

     // Start the connection
     connection.start();

     // And, send the message
     sender.send(message);
     System.out.println("Sent message:\n" + message);

     // Now, receive the message
//     Message receivedMessage = receiver.receive(15000); // in ms or 15 seconds
   //  System.out.println("\nReceived message:\n" + receivedMessage);

     recordSuccess();
    	noMsg ++;
    }
    
  
  }
  catch (JMSException jmsex) {
    recordFailure(jmsex);
  }
  finally {
    if (sender != null) {
      try {
        sender.close();
      }
      catch (JMSException jmsex) {
        System.out.println("Sender could not be closed.");
        recordFailure(jmsex);
      }
    }
    if (receiver != null) {
      try {
        receiver.close();
      }
      catch (JMSException jmsex) {
        System.out.println("Receiver could not be closed.");
        recordFailure(jmsex);
      }
    }

    if (session != null) {
      try {
        session.close();
      }
      catch (JMSException jmsex) {
        System.out.println("Session could not be closed.");
        recordFailure(jmsex);
      }
    }

    if (connection != null) {
      try {
        connection.close();
      }
      catch (JMSException jmsex) {
        System.out.println("Connection could not be closed.");
        recordFailure(jmsex);
      }
    }
  }
  System.exit(status);
  return;
} // end main()

/**
 * Process a JMSException and any associated inner exceptions.
 * 
 * @param jmsex
 */
private static void processJMSException(JMSException jmsex) {
  System.out.println(jmsex);
  Throwable innerException = jmsex.getLinkedException();
  if (innerException != null) {
    System.out.println("Inner exception(s):");
  }
  while (innerException != null) {
    System.out.println(innerException);
    innerException = innerException.getCause();
  }
  return;
}

/**
 * Record this run as successful.
 */
private static void recordSuccess() {
  System.out.println("SUCCESS");
  status = 0;
  return;
}

/**
 * Record this run as failure.
 * 
 * @param ex
 */
private static void recordFailure(Exception ex) {
  if (ex != null) {
    if (ex instanceof JMSException) {
      processJMSException((JMSException) ex);
    }
    else {
      System.out.println(ex);
    }
  }
  System.out.println("FAILURE");
  status = -1;
  return;
}

}

