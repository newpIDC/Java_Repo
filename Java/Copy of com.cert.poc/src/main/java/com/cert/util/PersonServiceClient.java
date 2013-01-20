package com.cert.util;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.cert.model.Person;



public class PersonServiceClient {
	
	public static void callPersonservice(Person person) throws AxisFault{
	  RPCServiceClient serviceClient = new RPCServiceClient();

      Options options = serviceClient.getOptions();

      EndpointReference targetEPR = new EndpointReference(
              "http://localhost:8080/axis2/services/personService");
      options.setTo(targetEPR);

      // Setting the weather
      QName opSetWeather =
          new QName("http://service.pojo.sample/xsd", "getPersonDetails");     

      Object[] opSetPersonArgs = new Object[] { person };

      OMElement response =  serviceClient.invokeBlocking(opSetWeather, opSetPersonArgs);
      
      System.out.println( response.toString() );
	}
}
