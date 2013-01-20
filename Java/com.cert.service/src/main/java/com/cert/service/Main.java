package com.cert.service;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.async.AxisCallback;
import org.apache.axis2.context.MessageContext;

public class Main {
	static boolean complete = false;
	public static void main(String... arg) throws AxisFault, InterruptedException{
		ServiceClient sc = new ServiceClient();
		// create option object
		Options opts = new Options();
		//setting target EPR
		opts.setTo(new EndpointReference(
		"http://127.0.0.1:8080/axis2/services/MyService"));
		//Setting action
		opts.setAction("urn:echo");
		//setting created option into service client
		sc.setOptions(opts);
		//OMElement res = sc.sendReceive(createPayLoad());
		//System.out.println(res);
		
		
		//creating callback object
		
		AxisCallback callback = new AxisCallback() {
		public void onMessage(MessageContext msgContext) {
		System.out.println(
		msgContext.getEnvelope().getBody().getFirstElement());
		complete = true;
		}
		public void onFault(MessageContext msgContext) {
		System.err.print(msgContext.getEnvelope().toString());
		}
		public void onError(Exception e) {
		e.printStackTrace();
		}
		public void onComplete() {
		complete = true;
		}
		};
		
		//invoking the service
		sc.sendReceiveNonBlocking(createPayLoad(), callback);
		System.out.println("-------Invoke the service---------");
		int index = 0;
		//wait till you get the response, in real applications you do not need
		//to do this, since once the response arrive axis2 will notify
		// callback, then you can implement callback to do whatever you want,
		//may be to update GUI
		while (!complete) {
		Thread.sleep(1000);
		index++;
		if (index > 10) {
		throw new AxisFault("Time out");
		}
		}
	}
	
	public static OMElement createPayLoad() {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace(
		"http://service.cert.com", "ns1");
		OMElement method = fac.createOMElement("echo", omNs);
		OMElement value = fac.createOMElement("value", omNs);
		value.setText("Hello , my first service utilization");
		method.addChild(value);
		return method;
	}
}
