package com.ibm.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueReceiver;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class MessageProducer {
	
	public void send( MQQueueConnectionFactory cf, int noMsg ){
		  // Variables
		  MQQueueConnection  connection = null;
		  MQQueueSession session = null;
		  MQQueue queue = null;
		  MQQueueSender sender = null;

		  try {
		    // Create JMS objects
		    connection = (MQQueueConnection) cf.createQueueConnection();
		    session = (MQQueueSession) connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		    queue = (MQQueue) session.createQueue("queue:///Q1");
		    sender = (MQQueueSender) session.createSender(queue);
//		    queue.setTargetClient(1);
		    
		 // set the reply queue
		    Queue tmpQueue =  session.createTemporaryQueue();
		  
		    Destination dest = tmpQueue;
		    int index = 0;    
		    
		    String messageID = "";
		    while(index < noMsg){
		    		long uniqueNumber = System.currentTimeMillis() % 1000;
		    		TextMessage message = session.createTextMessage("SimpleWMQJMSPTP: Your lucky number today is " + uniqueNumber);
		    		
		    		// Start the connection
		    		connection.start();

		    		// And, send the message
//		    		message.setJMSReplyTo(tmpQueue);
		    		sender.send (message);
//		    		if(index == 1){ messageID = message.getJMSMessageID(); }
		    		System.out.println("Sent message  Id:\n" + message.getJMSMessageID());
		    		index++;
		    }
		    /*
		    String selector = "JMSCorrelationID = '"+messageID+"'";
		    QueueReceiver receiver = session.createReceiver(queue);
		    
		 
		    Message msg = receiver.receive(100);
		    System.out.println("JMS Reply to:\t" + msg.getJMSReplyTo());
		    System.out.println("Received message ID:\t" + msg.getJMSMessageID());
		    System.out.println("Received message corralation ID\t" + msg.getJMSCorrelationID());
		 */   
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  finally {
			  if (sender != null) {
			        try {
			          sender.close();
			        }
			        catch (JMSException jmsex) {
			          System.out.println("Session could not be closed.");
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
