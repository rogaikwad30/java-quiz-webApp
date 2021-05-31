package com.jcg.mongodb.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class Details extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	 
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
			 String test = req.getParameter("testid"); 
			 Util.getStudents(test);
			 
			 System.out.println("id : "+ test);
	
		 
 	 }	 

	 public void renderPage( PrintWriter out, String[] list  ) { 
	      
	}

}
