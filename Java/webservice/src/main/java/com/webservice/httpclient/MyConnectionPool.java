package com.webservice.httpclient;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

public enum MyConnectionPool {
	
	INSTANCE;	

	public PoolingClientConnectionManager createConnectionPool(){
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(
	         new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
		schemeRegistry.register(
	         new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
		PoolingClientConnectionManager _cm ;
		_cm = new PoolingClientConnectionManager(schemeRegistry);
		// Increase max total connection to 200
		_cm.setMaxTotal(200);
		// 	Increase default max connection per route to 20
		_cm.setDefaultMaxPerRoute(20);
		//Increase max connections for localhost:80 to 50
		//HttpHost localhost = new HttpHost("locahost", 80);
		//cm.setMaxPerRoute(new HttpRoute(localhost), 50);	 
		//HttpClient httpClient = new DefaultHttpClient(cm);
		return _cm;
	}
}
