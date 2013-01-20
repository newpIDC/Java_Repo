/*package com.wellsfargo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*//**
 * Servlet implementation class Helloservlet
 *//*
//@WebServlet("/Helloservlet")
public class Helloservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    *//**
     * Default constructor. 
     *//*
    public Helloservlet() {
        // TODO Auto-generated constructor stub
    	
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("In doPost !");
				Person p = new Person();
				p.setName("Evan");
				request.setAttribute("person", p);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Hello.jsp");
				view.forward(request, response);
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In doPost !");
		Person p = new Person();
		p.setName("Evan");
		request.setAttribute("person", p);
		RequestDispatcher view = request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/Hello.jsp");
		view.forward(request, response);	
	}

	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In doService !");
		Person p = new Person();
		p.setName("Evan");
		request.setAttribute("person", p);
		RequestDispatcher view = request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/Hello.jsp");
		view.forward(request, response);	
	}
}
*/