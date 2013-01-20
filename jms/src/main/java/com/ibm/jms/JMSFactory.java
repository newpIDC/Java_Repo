package com.ibm.jms;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.jms.JmsQueue;
import com.ibm.msg.client.wmq.WMQConstants;

public class JMSFactory {
	
	public void browse(){
		// Variables
	    Connection connection = null;
	    Session session = null;
	    Queue destination = null;
	    Destination tempDestination = null;
	    QueueBrowser browser = null;

	    try {
	      // Create a connection factory
	      JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
	      JmsConnectionFactory cf = ff.createConnectionFactory();

	      // Set the properties
	      cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, "localhost");
	      cf.setIntProperty(WMQConstants.WMQ_PORT, 1414);
	      cf.setStringProperty(WMQConstants.WMQ_CHANNEL, "SYSTEM.DEF.SVRCONN");
	      cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
	      cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, "IBM.QM");

	      String selector = "JMSMessageID='ID:414d512049424d2e514d202020202020f4cbf35020003002'";
	      // Create JMS objects
	      connection = cf.createConnection();
	      session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	      destination = session.createQueue("queue:///Q1");
	      browser = session.createBrowser(destination, selector);

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
	        System.out.println(current);
	      }
	      System.out.println("\nNo more messages\n");

	      
	    }catch (JMSException jmsex) {
	        jmsex.printStackTrace();
	    }finally {
	        if (browser != null) {
	            try {
	              browser.close();
	            }
	            catch (JMSException jmsex) {
	              System.out.println("Browser could not be closed.");
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
