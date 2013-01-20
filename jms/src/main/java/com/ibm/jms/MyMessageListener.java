package com.ibm.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener  implements MessageListener {
	
	private int noMsg = 0;
	
	@Override
	public void onMessage( Message message ) {
		if( message instanceof TextMessage ){
			try {
				System.out.println("Message Text:\t" + ((TextMessage) message).getText());
				System.out.println("JMS ID:\t" + message.getJMSMessageID());
				noMsg++;
				message.acknowledge();
			} catch (JMSException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public int getNoMsg() {
		return noMsg;
	}




}
