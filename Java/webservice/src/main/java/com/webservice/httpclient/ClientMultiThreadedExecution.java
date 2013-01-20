package com.webservice.httpclient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class ClientMultiThreadedExecution {

	public static void doMultiThreaded() throws InterruptedException{
		 SchemeRegistry schemeRegistry = new SchemeRegistry();
		    schemeRegistry.register(
		    new Scheme("http", 18080, PlainSocketFactory.getSocketFactory()));

		    ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(schemeRegistry);
		    cm.setDefaultMaxPerRoute(5);
		    cm.setMaxTotal(5);


		    HttpClient httpclient = new DefaultHttpClient(cm);
		    try {
		        // create an array of URIs to perform GETs on
		        String uri = "http://localhost:8080/";
		        String data = "This is a test message";

		        System.out.println("Started at: " + new Date());
		        // creating 10 threads
		        PostThread[] threads = new PostThread[10];

		        for (int i = 0; i < threads.length; i++) {
		        HttpPost httpPost = new HttpPost(uri);
		        threads[i] = new PostThread(httpclient, httpPost, data, i + 1);
		            threads[i].start();
		            //Thread.sleep(1000);
		        }

		       // join the threads
		        for (int j = 0; j < threads.length; j++) {
		            threads[j].join();
		        }

		    } finally {
		        // When HttpClient instance is no longer needed,
		        // shut down the connection manager to ensure
		        // immediate deallocation of all system resources
		        System.out.println("Ended at: " + new Date());
		        httpclient.getConnectionManager().shutdown();
		    }
	}

/**
 * A thread that performs a POST.
 */
static class PostThread extends Thread {

    private final HttpClient httpClient;
    private final HttpContext context;
    private final HttpPost httpPost;
    private final int id;
    private final String data;

    public PostThread(HttpClient httpClient, HttpPost httpPost, String data, int id) {
        this.httpClient = httpClient;
        this.context = new BasicHttpContext();
        this.httpPost = httpPost;
        this.id = id;
        this.data = data;
    }

    /**
     * Executes the PostMethod and prints some status information.
     */
    @Override
    public void run() {

        //System.out.println(id + " - about to get something from " + httpPost.getURI());

        try {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("XML",data));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));

            // execute the method
            HttpResponse response = httpClient.execute(httpPost, context);

            //System.out.println(id + " - get executed");
            // get the response body as an array of bytes
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
                System.out.println("Success");

            //Is this step necessary ?? Need to check as only status code is required
            //httpPost.abort();
            //HttpEntity entity = response.getEntity();

            //And this ?
            //EntityUtils.consume(entity);

        } catch (Exception e) {
            httpPost.abort();
            System.out.println(id + " - error: " + e);
        }
    }
}
}
