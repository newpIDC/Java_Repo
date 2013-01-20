package com.webservice.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.websevice.util.IOtask;


public class MyHttpClient {
	private static Logger logger = Logger.getLogger(MyHttpClient.class);
	
	public static void doClient() throws ClientProtocolException, IOException{
		
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(
	         new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		//schemeRegistry.register(
		//       new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
		PoolingClientConnectionManager cm ;
		cm = new PoolingClientConnectionManager(schemeRegistry);
		// Increase max total connection to 200
		cm.setMaxTotal(2);
		// 	Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(5);
		
		HttpClient httpclient = new DefaultHttpClient(cm);
		HttpGet httpget = new HttpGet("http://localhost:8080/");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    IOtask.readStream(instream);
		    instream.close();
		    
		}
	}
}
