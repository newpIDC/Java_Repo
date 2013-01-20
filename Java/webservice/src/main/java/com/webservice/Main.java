package com.webservice;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.apache.http.client.ClientProtocolException;
import org.jaxen.JaxenException;

import com.webservice.httpclient.ClientMultiThreadedExecution;
import com.webservice.httpclient.MyHttpClient;

public class Main {

	/**
	 * @param args
	 * @throws XMLStreamException 
	 * @throws JaxenException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws InterruptedException 
	 */
	public static void main(String... args) 
					throws XMLStreamException, JaxenException, 
							ClientProtocolException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Axiom.doAxiom();
		Axiom.doXPath();
		Axiom.doSoap();		
		
		//MyHttpClient.doClient();
		ClientMultiThreadedExecution.doMultiThreaded();
	}

}
