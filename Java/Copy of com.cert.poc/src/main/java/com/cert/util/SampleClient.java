package com.cert.util;

import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.Constants;
import org.apache.axis2.client.ServiceClient;

import com.cert.model.Person;



public class SampleClient  implements Runnable{
	private static final EndpointReference _targetEPR = new EndpointReference(
				"http://localhost:8080/axis2/services/personService");
	public Person _person;
	
	public SampleClient(Person person){
		_person = person;
	}
	
	private static OMElement greetUserPayload(String personToGreet) {
			OMFactory fac = OMAbstractFactory.getOMFactory();
			OMNamespace omNs = fac.createOMNamespace("http://example1.org/example1", "example1");
			OMElement method = fac.createOMElement("sayHello", omNs);
			OMElement value = fac.createOMElement("personToGreet", omNs);
			value.addChild(fac.createOMText(value, personToGreet));
			method.addChild(value);
			return method;
	}

	private static void callPersonService(Person person) {
		try {		
			OMElement payload = SampleClient.greetUserPayload(person.getName());
			Options options = new Options();
			options.setTo(_targetEPR);
			options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
			ServiceClient sender = new ServiceClient();
			sender.setOptions(options);
			OMElement result = sender.sendReceive(payload);
			String response = result.getFirstElement().getText();
			System.out.println(response);
		} catch (Exception e) { // (XMLStreamException e) {
			System.out.println(e.toString());
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		callPersonService(_person);
		
	}
}
