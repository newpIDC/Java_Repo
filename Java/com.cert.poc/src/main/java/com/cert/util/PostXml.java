package com.cert.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.Header;
//import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

public class PostXml {

	public static void postXML(){
		 try {
		      String xmldata = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
			"<env:Envelope " + 
			  "env:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" " + 
			  "xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" " + 
			  "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " + 
			  "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
			  "<env:Header/>" +
		          "<env:Body>" +
			    "<ans1:readLS xmlns:ans1=\"http://phonedirlux.homeip.net/types\">" +
			      "<String_1 xsi:type=\"xsd:string\">your message or e-mail</String_1>" +
			    "</ans1:readLS>" +
			  "</env:Body>" +
		        "</env:Envelope>";
					
		      //Create socket
		      String hostname = "www.pascalbotte.be";
		      int port = 80;
		      InetAddress  addr = InetAddress.getByName(hostname);
		      Socket sock = new Socket(addr, port);
					
		      //Send header
		      String path = "/rcx-ws/rcx";
		      BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
		      // You can use "UTF8" for compatibility with the Microsoft virtual machine.
		      wr.write("POST " + path + " HTTP/1.0\r\n");
		      wr.write("Host: www.pascalbotte.be\r\n");
		      wr.write("Content-Length: " + xmldata.length() + "\r\n");
		      wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
		      wr.write("\r\n");
					
		      //Send data
		      wr.write(xmldata);
		      wr.flush();
					
		      // Response
		      BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		      String line;
		      while((line = rd.readLine()) != null)
			System.out.println(line);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  
	}
	
	public static void doHttpClient() throws ClientProtocolException, URISyntaxException,IOException{
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://localhost:8889/portal/");		
		URIBuilder builder = new URIBuilder();		
		builder.setScheme("http").setHost("hcf-uathula.wellsfargo.com").setPath("/portal");
		    /*.setParameter("q", "httpclient")
		    .setParameter("btnG", "Google Search")
		    .setParameter("aq", "f")
		    .setParameter("oq", "");*/
		
		URI  uri = builder.build();		
		httpget = new HttpGet(uri);
		System.out.println(httpget.getURI());
		HttpResponse response = httpclient.execute(httpget);
		
		doPrintln(response.getStatusLine());
		
		doPrintWork(response.getAllHeaders());
}
	
	private static void doPrintln(Object obj){
		System.out.println(obj.toString());
	}
	
	private static void doPrintWork(Header... arrHeaders){
		String sFormat = "Header Name is : %s\t  Value is : %3s";
		for(Header header : arrHeaders){			
			System.out.println(String.format(sFormat, header.getName(), header.getValue()));
		}
		
	}
}