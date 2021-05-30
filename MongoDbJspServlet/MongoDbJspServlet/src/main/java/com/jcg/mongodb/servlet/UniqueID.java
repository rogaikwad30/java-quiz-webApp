package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UniqueID extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		    PrintWriter out = resp.getWriter();
 	        String error = (String) req.getAttribute("error") ;
	 	 	renderPage( out , error );
	 	 		
	 	 		
	 	 }	 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
 	    PrintWriter out = resp.getWriter();
 	    String error = (String) req.getAttribute("error") ;
 	       
 	 	renderPage( out , error );
 	 		
 	 		
 	 }	 

	public void renderPage( PrintWriter out  , String error ) {
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>uniqueId</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/navbar.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/uniqueId.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <header>\r\n"
				+ "        <div class=\"menu-toggle\" id=\"hamburger\">\r\n"
				+ "            <i class=\"fas fa-bars\"></i>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"overlay\"></div>\r\n"
				+ "        <div class=\"container\">\r\n"
				+ "            <nav>\r\n"
				+ "                <h4 class=\"brand\"><a href=\"#\" style=\"text-decoration: none; color: aliceblue; font-size: 24px;font-weight: bold; letter-spacing: 1.25px;\">Email</h4>\r\n"
				+ "                <ul>\r\n"
				+ "\r\n"
				+ "                    <li><a href=\"DashBoard\" class=\"link\">DashBoard</a></li>\r\n"
				+ "                    <li><a href=\"DashBoard#takeQuiz\" class=\"link\">Take Quiz</a></li>\r\n"
				+ "                    <li><a href=\"YourQuiz\" class=\"link\">Create Quiz</a></li>\r\n"
				+ "                    <li><a href=\"logout\" class=\"link\">Logout</a></li>\r\n"
				+ "                    \r\n"
				+ "                </ul>\r\n"
				+ "            </nav>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "        <div class=\"container\">\r\n"
				+ "            <div class=\"row cbox\">\r\n"
				+ "                <span class=\"col-10 col-sm-8 col-md-6 col-lg-4 pb-4 offset-1 offset-sm-2 offset-md-3 offset-lg-4 idBox \">\r\n"
				+ "                    <form action=\"Search\" class=\"row\" method=\"POST\">\r\n"
				+ "                        <input class=\"col-10 mt-5 py-3 offset-1 \" placeholder=\"Hit Test Code\"  type=\"text\" name=\"id\" value=\"\" id=\"code\" required>\r\n"
				+ "                        \r\n"
				+ "                        <input id=\"start\"  class=\"col-10 mt-5 mb-4 py-2 offset-1 btn btn-success\"   type=\"submit\" value=\"Start Test\">\r\n"
				+ "                    </form>\r\n"
				+ "\r\n"
				+ "");
 	 	
 	 	
 	 	
 	 	
 	 	if(error != null) {
 	 		out.println(" <span class=\"col-10 \" style=\"color: red; font-size: 14px; font-weight: bold;\">"+ error +"</span>\r\n"); 	
 	 	}
 	 
 	 	 
 	 	
 	 	
 	 	out.println("      \r\n"
 	 			+ "                </span>\r\n"
 	 			+ "            </div>\r\n"
 	 			+ "        </div>\r\n"
 	 			+ "     \r\n"
 	 			+ "     \r\n"
 	 			+ "    </header>\r\n"
 	 			+ "\r\n"
 	 			+ "   \r\n"
 	 			+ "\r\n"
 	 			+ "\r\n"
 	 			+ "</body>\r\n"
 	 			+ "<script src=\"./js/navbar.js\"></script>\r\n"
 	 			+ "</html>");
	}

}
