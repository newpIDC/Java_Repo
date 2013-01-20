package com.ibm.jms;

import javax.jms.JMSException;

import com.ibm.mq.jms.JMSC;
import com.ibm.mq.jms.MQQueueConnectionFactory;

public class Main {
	
	private static MQQueueConnectionFactory _cf;
	public static void main(String[] args) throws JMSException, InterruptedException {
		//setConnectionFactory();
		
		/*MessageBrowser msgRcObj = new MessageBrowser();
		msgRcObj.receive();*/
		
		JMSFactory jmsfObj = new JMSFactory();
		jmsfObj.browse();
		
		/*SampleConsumer msgConObj = new SampleConsumer();
		msgConObj.consume();
		*/
		
		
		
	/*
		MessageProducer msgProdObj = new MessageProducer();
		msgProdObj.send(_cf, 10);*/
		
		
		/*AyncConsumer asyncConObj = new AyncConsumer();
		asyncConObj.consumeAync(_cf);
	*/
		
		/*
		MQGetPut getputObj = new MQGetPut();	
		getputObj.start();
		*/
		
		IBMLegacy  ibmLObj = new IBMLegacy();
		ibmLObj.getDepth();
		
		MQSample.putGet(null);
	}
	
	private  static void setConnectionFactory() throws JMSException{
	    // Create a connection factory

			_cf = new MQQueueConnectionFactory();

	    // Set the properties
		// Config
	      _cf.setHostName("localhost");
	      _cf.setPort(1414);
	      _cf.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
	      _cf.setQueueManager("IBM.QM");
	      _cf.setChannel("SYSTEM.DEF.SVRCONN");
	}

}
