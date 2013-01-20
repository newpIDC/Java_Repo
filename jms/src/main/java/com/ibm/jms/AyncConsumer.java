package com.ibm.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQMessageConsumer;
import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueSession;

public class AyncConsumer implements MessageListener{
	
	private Object _lock = new Object();
	
	public void consumeAync( MQQueueConnectionFactory cf ) throws InterruptedException{
		 
		System.out.println("In consumeAync methods.");
		
		  // Variables
		  QueueConnection  connection = null;
		  QueueSession session = null;
		  Queue queue = null;
		  MessageConsumer consumer = null;
		  MyMessageListener listener = null;

		  try {
		    // Create JMS objects
		    connection = cf.createQueueConnection();
		    session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		    queue =  session.createQueue("queue:///Q1");
		    consumer =  session.createConsumer(queue);
//		    listener = new MyMessageListener();		    
		    consumer.setMessageListener(this);
		    connection.start();
//		    System.out.println("No. of messages consumed is:\t" + listener.getNoMsg());
//		    while(true){ }
		    
		    synchronized(_lock){		    	
		    	while(_noMsg != 10){
		    		_lock.wait();
		    	}
		    	
		    }
		    
		  }catch(JMSException e){
			  e.printStackTrace();
		  }finally{
			  if (consumer != null){
				  try{
					  consumer.close();
				  }catch (JMSException e){
					  e.printStackTrace();
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
	
	int _noMsg = 0;
	
	@Override
	public void onMessage( Message message ) {
		System.out.println("In onMessage method.");
		if( message instanceof TextMessage ){
			try {
				System.out.println("Message Text:\t" + ((TextMessage) message).getText());
				System.out.println("JMS ID:\t" + message.getJMSMessageID());
				if(_noMsg++ == 10){
					synchronized(_lock){
						_lock.notifyAll();
					}
				}
				System.out.println("No Of Messages:\t" + _noMsg);
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
