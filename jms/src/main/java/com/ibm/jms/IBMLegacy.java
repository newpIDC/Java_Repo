package com.ibm.jms;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
public class IBMLegacy {

	public void getDepth( ){
		
		
		MQQueueManager queueManager = null;
	    MQQueue queue = null;
	    MQMessage queueMessage = new MQMessage();

	    MQEnvironment.hostname = "localhost";           // Could have put the  
        // hostname & channel  
   	 	MQEnvironment.channel  = "SYSTEM.DEF.SVRCONN";            // string directly here!  
   	 	MQEnvironment.port = 1414;
   	 	MQEnvironment.properties.put(MQC.TRANSPORT_PROPERTY,//Set TCP/IP or server  
   	 						MQC.TRANSPORT_MQSERIES);//Connection  
   	
   	 	String qName = "Q1";
   	 	String qmName = "IBM.QM";
   	 	//int openOptions = MQC.MQOO_INQUIRE;
   		int openOptions = MQConstants.MQOO_INQUIRE;

	    try {
			queueManager = new MQQueueManager(qmName);
		
			queue = queueManager.accessQueue(qName, openOptions);
			int depth = queue.getCurrentDepth();
			System.out.println("depth:\t" + depth);
			queue.close();
			queueManager.disconnect();
			/* MQGetMessageOptions opt = new MQGetMessageOptions();
	    	if (opt != null)
	    	{
	        	opt.options = IBM.WMQ.IBMLegacy.MQGMO_BROWSE_FIRST;
	        	queueMessage.correlationId = IBM.WMQ.IBMLegacy.MQMI_NONE;
	        	queueMessage.messageId = IBM.WMQ.IBMLegacy.MQMI_NONE;
	    	}

	    	queue.Get(queueMessage, opt);
	    	String sMessage = queueMessage.ReadString(queueMessage.DataLength);
			 */
	    } catch (MQException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
