package com.webservice;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.builder.StAXBuilder;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.xpath.AXIOMXPath;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.log4j.Logger;
import org.jaxen.JaxenException;

public class Axiom {
	
	private static Logger logger = Logger.getLogger(Axiom.class);
	
	public static void doAxiom() throws XMLStreamException, JaxenException{
	String xmlString = "<book>" +
			"<name>Quick-start Axis</name>" +
			"<isbn>978-1-84719-286-8</isbn>" +
			"</book>";
			ByteArrayInputStream xmlStream = new ByteArrayInputStream(xmlString.getBytes());
			//create a builder. Since we want the XML as a plain XML, we can just use
			//the plain OMBuilder
			StAXBuilder builder = new StAXOMBuilder(xmlStream);
			//return the root element.
			OMElement omElement = builder.getDocumentElement();
			//System.out.println(omElement.toStringWithConsume());
			
			//Obtain a factory
			OMFactory factory = OMAbstractFactory.getOMFactory();
			//use the factory to create two name space object
			OMNamespace axis2 = factory.createOMNamespace("axis2","ns");
			//use the factory to create three elements to represent the book element
			OMElement root = factory.createOMElement("book",axis2);
			OMElement name = factory.createOMElement("name",axis2);
			OMElement isbn = factory.createOMElement("isbn",axis2);
			OMAttribute type = factory.createOMAttribute("type",null, "web-services");
			
			root.addAttribute(type);
			root.addChild(name);
			root.addChild(isbn);
			
		//	System.out.println(root.toStringWithConsume());
			
			Iterator children = root.getChildren();
			while(children.hasNext()){
				OMNode node = (OMNode)children.next();
				logger.info(node);
			}
						
			XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(System.out);
			//dump the output to console with caching
			root.serializeAndConsume(writer);
			root.serialize(writer);
			writer.flush();
			
	}
	
	public static void doXPath() throws XMLStreamException, JaxenException{
		String xmlStream = "<book type=\"web-services\"><name></name><isbn>56789</isbn></book>";
				
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlStream.getBytes());
				StAXBuilder builder = new StAXOMBuilder(byteArrayInputStream);
				OMElement root = builder.getDocumentElement();
				AXIOMXPath xpath = new AXIOMXPath("/book/isbn[1]");
				OMElement selectedNode = (OMElement) xpath.selectSingleNode(root);
				logger.info(selectedNode.getText());
	}
	
	public static void doSoap(){
		
				OMFactory factory = OMAbstractFactory.getOMFactory();
				OMNamespace axis2 = factory.createOMNamespace("axis2", "ns");
				OMElement root = factory.createOMElement("book", axis2);
				OMAttribute type = factory.createOMAttribute("type",null,"web-services");
				root.addAttribute(type);
				OMElement name = factory.createOMElement("name", axis2);
				OMElement isbn = factory.createOMElement("isbn", axis2);
				root.addChild(name);
				root.addChild(isbn);
				SOAPFactory soapFactory = OMAbstractFactory.getSOAP12Factory();
				//	get the default envelope
				SOAPEnvelope env = soapFactory.getDefaultEnvelope();
				//add the created child
				env.getBody().addChild(root);
				logger.info( env);	
		
	}
}
