package com.ibm.jms;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class MessageBrowser {
	
	public void receive( ){
		
		 // Variables
		  MQQueueConnection  connection = null;
		  MQQueueSession session = null;
		  MQQueue queue = null;
		  MQQueueSender sender = null;
		  MQQueueReceiver receiver = null;
		  Queue destination = null;
		  QueueBrowser browser = null;

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
		    
		     String messageID = "414d512049424d2e514d2020202020200446f2502000290b"; 
		     String selector = "JMSCorrelationID = '"+messageID+"'";
		     browser = session.createBrowser(queue);

		      // Start the connection
		      connection.start();

		      // And, browse the message
		      Enumeration messages = browser.getEnumeration();
		      int count = 0;
		      Message current;
		      System.out.println("Browse starts");
		      while (messages.hasMoreElements()) {
		        current = (Message) messages.nextElement();
		        System.out.println("\nMessage " + ++count + ":\n");
		        System.out.println(current.getJMSMessageID());
		      }
		      System.out.println("\nNo more messages\n");

		    
		    
//		    sender = (MQQueueSender) session.createSender(queue);
	/*	    receiver = (MQQueueReceiver) session.createReceiver(queue);
		    
		    while( 1 == 1){
		    	Message msg = receiver.receive();
		    	System.out.println(msg.getJMSMessageID());
		    }
		    */
		    
	}catch(JMSException ex){
		ex.printStackTrace();
	}
	finally {
	    if (sender != null) {
	      try {
	        sender.close();
	      }
	      catch (JMSException jmsex) {
	        System.out.println("Sender could not be closed.");
	      }
	    }
	    if (receiver != null) {
	      try {
	        receiver.close();
	      }
	      catch (JMSException jmsex) {
	        System.out.println("Receiver could not be closed.");
	      }
	    }

	    if (session != null) {
	      try {
	        session.close();
	      }
	      catch (JMSException jmsex) {
	        System.out.println("Session could not be closed.");
	      }
	    }

	    if (connection != null) {
	      try {
	        connection.close();
	      }
	      catch (JMSException jmsex) {
	        System.out.println("Connection could not be closed.");
	      }
	    }
	  }
}

}