package com.ibm.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueReceiver;
import javax.jms.Session;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQMessageConsumer;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class SampleConsumer {
	
	public void consume( ){
		 // Variables
		  MQQueueConnection  connection = null;
		  MQQueueSession session = null;
		  MQQueue queue = null;
		  MQQueueSender sender = null;
		  MQQueueReceiver receiver = null;
		  Queue destination = null;
		  QueueBrowser browser = null;
		  
		  try{
			  
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
           
//		    Destination dest = (Destination) session.createQueue("queue:///Q1");
//            MQMessageConsumer msgConsumer = (MQMessageConsumer)session.createConsumer(dest);
		    String mgId = "414d512049424d2e514d2020202020209c5df150200372e9";
            queue = (MQQueue) session.createQueue("queue:///Q1");
            QueueReceiver  mqreceiver =session.createReceiver(queue);
            connection.start();           
            
            int msgRecNo = 0;
            while(true){
            	
            	Message msg = mqreceiver.receive(100);
            	if( null != msg) {   	System.out.println(msg.getJMSMessageID());}
            	else{
            		System.out.println("Message is NULL.");
            		break;
            	}
            	msgRecNo++;     
            	 // Sleep for a while to allow the user to see the output on the screen
//                Thread.sleep(3 * 1000);
            }
            
            System.out.println("No of Message consumed:\t" + msgRecNo);    
		  }catch(Exception e){
			  e.printStackTrace();
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
