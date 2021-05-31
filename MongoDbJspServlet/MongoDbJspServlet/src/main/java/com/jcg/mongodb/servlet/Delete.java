package com.jcg.mongodb.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class Delete extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	 
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		try {			
			String ques = (String) req.getParameter("id");
			String test = (String) req.getParameter("testID");
			ObjectId id = new ObjectId(ques);
			ObjectId testid = new ObjectId(test);
			
			Util.deleteQues(testid, id);
			System.out.println(id +" " + testid);
			req.setAttribute("test", test);
			RequestDispatcher rd =  req.getRequestDispatcher("Preview");
			rd.forward(req,resp);
		}
		catch (Exception e) {
			 out.println("Invalid ID or test");
		}
		 
 	 }	 

}
