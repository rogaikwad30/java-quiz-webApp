package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;

public class Search extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		handleRequest(req, resp);
	}
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String  temp = req.getParameter("id");
		System.out.println(temp);
		
		try {
			ObjectId id = new ObjectId(temp);
			System.out.println(id);
			HashMap<String, String[]> Data =  Util.searchQuiz(id);
			String [] arr = new String[10];
			arr = Data.get("Answers");
			req.setAttribute("q",  Data.get("Questions") );
			req.setAttribute("ca",  Data.get("Answers") );
			req.setAttribute("a",	Data.get("OptionA"));
			req.setAttribute("b",	Data.get("OptionB"));		
			req.setAttribute("c",   Data.get("OptionC"));
			req.setAttribute("id", id.toString());
			
			RequestDispatcher rd =  req.getRequestDispatcher("Test");
			rd.forward(req,resp);
			
			  
		    } catch (Exception e) {
		      System.out.println("Something went wrong.");
		      req.setAttribute("error","Invalid ID");
		      RequestDispatcher rd =  req.getRequestDispatcher("uniqueID");
			  rd.forward(req,resp);
		    }
	    
	}
}

 