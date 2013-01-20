package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    	//domain=FlexA&instances=ldrza8191.wellsfargo.com&port=6080
    	String domain = request.getParameter("domain");
    	String instances = request.getParameter("instances");
    	String port = request.getParameter("port");
    	
    	System.out.println("instances\t" + instances);
    	try {
    		 response.setContentType("text/html");
			response.getWriter().print(instances + " got enabled.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

}
