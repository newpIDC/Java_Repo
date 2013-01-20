package com.practice.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class IamHavingMain {
	public static void main(String[] arg) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		

		 try {
	 
			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	 
		
		Customer customer = new Customer();
		  customer.setId(100);
		  customer.setName("mkyong");
		  customer.setAge(29);
	 
		  try {
	 
			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);
	 
		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	 
		
		
		
		String xml =
				"<resp>" +
				    "<status>" +
				    	"good" +
				    "</status>" +
				    	"<msg>" +
				    		"hi" +
				    	"</msg>" +
				  "</resp>";
		String cityXML =
				"<city>" +
						"<stock>" +
							"<name>" +
								"Sony" +
							"</name>" +
						"</stock>" +
						"<stock> " +
							"<name>" +
								"Panasonic" +
							"</name>" +
							"<substocks>" +
								"<stock> " +
									"<name>" +
										"Panasonic Shop 2" +
									"</name>" +
								"</stock>" +
							"</substocks>" +
						"</stock>" +
				"</city>";

		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		InputSource source = new InputSource(new StringReader(xml));
		String status = xpath.evaluate("/resp/msg", source);
		System.out.println("satus=" + status);
		
	/*	Document dom= DocumentBuilderFactory().newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
		Element root= dom.getDocumentElement();
		for(Node n=root.getFirstChild();n!=null;n=n.getNextSibling())
		 {
		 System.err.print("Current node is:"+n);
		 }*/
		
	//	final InputStream is = new FileInputStream('your.xml');
		source = new InputSource(new StringReader(cityXML));
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document doc = builder.parse(source);
		final XPathFactory xPathfactory = XPathFactory.newInstance();
	    xpath = xPathfactory.newXPath();
		final XPathExpression expr = xpath.compile("/city/stock/name");

		final NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		for(int i=0; i< nl.getLength(); i++){
			System.out.println(nl.item(i).getNodeValue());
		}
		
		//____________________
		
		//XStream xstream = new XStream();
		//XStream xstream = new XStream(new DomDriver()); 
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.alias("person", Person.class);
		xstream.alias("phonenumber", PhoneNumber.class);		
		Person joe = new Person("Joe", "Walnes");
		joe.setPhone(new PhoneNumber(123, "1234-456"));
		joe.setFax(new PhoneNumber(123, "9999-999"));		
		String personXML = xstream.toXML(joe);		
		System.out.println(personXML);		
		
		String json = "{\"product\":{\"name\":\"Banana\",\"id\":\"123\""
			    + ",\"price\":\"23.0\"}}";
		xstream.alias("product", Product.class);
		Product product = (Product)xstream.fromXML(json);
		System.out.println(product.getName());
	}

}
