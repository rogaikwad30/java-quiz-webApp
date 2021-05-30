package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static String r = null;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		        PrintWriter out = resp.getWriter();
		    
		        UserData.email = "";
		    	RequestDispatcher rd =  req.getRequestDispatcher("dashBoard.html");
				rd.forward(req,resp);
		    
	}	 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 UserData.email = "";
 	    PrintWriter out = resp.getWriter(); 
 	    RequestDispatcher rd =  req.getRequestDispatcher("dashBoard.html");
		rd.forward(req,resp);
   
 	 		
 	 }	 
 

}
