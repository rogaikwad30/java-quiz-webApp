package com.jcg.mongodb.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class Preview extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	 
	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {			
			String TEST = (String) req.getParameter("code") ;
			if(TEST == null) {
				TEST = (String) req.getAttribute("test");
			}
			ObjectId id = new ObjectId(TEST);
			System.out.println(TEST);
			PrintWriter out = resp.getWriter();
			HashMap<String, String[]> Data =  Util.searchQuiz(id);
			System.out.println("length " + Data.get("Questions").length );
			
			renderPage(out ,Data.get("Questions") , Data.get("Answers") ,Data.get("OptionA") ,Data.get("OptionB") ,Data.get("OptionC") , id.toString() , Data.get("ids") );
		}
		catch (Exception e) {
			  String TEST = (String) req.getParameter("code");
		      System.out.println("Invalid ID :- "+ TEST ); 
		      PrintWriter out = resp.getWriter();
		      String [] arr = new String[0];
		       
		      renderPage(out ,arr, arr ,arr ,arr ,arr , null , null  );
		}
		 
 	 }	 

	public void renderPage( PrintWriter out  , String q[] , String a[] , String b[], String c[], String ca[] , String test , String [] ids) { 
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/createQuiz.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/dashBoard.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/previewTest.css\">\r\n"
				+ "    <title>PreviewQuiz</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"navbar container-fluid\">\r\n"
				+ "        <div class=\"row icons my-1\">\r\n"
				+ "            <a href=\"./createQuiz.html\" class=\" px-4   text-center  Link\" >\r\n"
				+ "                <i class=\"fab fa-quinscape mr-2 mb-2\"></i>\r\n"
				+ "                <b>Create Quiz</b>\r\n"
				+ "            </a>\r\n"
				+ "            <a href=\"DashBoard\" class=\"px-4    text-center Link\">\r\n"
				+ "                <i class=\"fas fa-home mr-2 mb-2\"></i>\r\n"
				+ "                <b>Home</b>\r\n"
				+ "            </a>\r\n"
				+ "            <a href=\"YourQuiz\" class=\"px-4  text-center Link\" >\r\n"
				+ "                <i class=\"fas fa-atom mr-2 mb-2\"></i>\r\n"
				+ "                <b>Take a Quiz</b>\r\n"
				+ "            </a>\r\n"
				+ "           <a href=\"logout\" class=\" px-4  float-right text-center Link\" >\r\n"
				+ "            <i class=\"fas fa-sign-out-alt mr-2 mb-2\"></i>\r\n"
				+ "            <b>SignOut</b>\r\n"
				+ "        </a>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "   <div class=\"container  t my-5\">\r\n"
				+ "    <table class=\"table table table-striped \">\r\n"
				+ "        <thead class=\"bg-dark\" style=\"color: aliceblue;\">\r\n"
				+ "          <tr>\r\n"
				+ "            <th scope=\"col\">#</th>\r\n"
				+ "            <th scope=\"col\">Question</th>\r\n"
				+ "            <th scope=\"col\">Correct</th>\r\n"
				+ "            <th scope=\"col\">Other</th>\r\n"
				+ "            <th scope=\"col\">Other</th>\r\n"
				+ "            <th scope=\"col\">Other</th>\r\n"
				+ "            <th scope=\"col\">Action</th>\r\n"
				+ "          </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>\r\n");
		
		
		
		
		
		
		
		for(int i=0; i<q.length; i++) {

			out.println("<tr>\r\n"
					+ "            <th scope=\"row\">1</th>\r\n"
					+ "            <td>"+  q[i]   + "?</td>\r\n"
					+ "            <td>"+  ca[i]      + "</td>\r\n"
					+ "            <td>"+  a[i]  +"</td>\r\n"
					+ "            <td>"+  b[i] +"</td>\r\n"
					+ "            <td>"+  c[i] + "</td>\r\n"
					+ "            <td> "+  
					"<form action=\"delete\" method=\"POST\">\r\n"
							+ "    <input type=\"text\" name=\"id\" hidden value=\""+ ids[i] +"\" required>\r\n"
							+ "    <input type=\"text\" name=\"testID\" hidden value=\""+ test +"\" required>\r\n"
							+ "    <input type=\"submit\" class=\"btn btn-success btn-sm p-1\" value=\"Delete\">\r\n"
							+ "</form>"  +"</td>\r\n"
							
					+ "          </tr>\r\n"
					+ "\r\n");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		out.println("        </tbody>\r\n"
				+ "    </table>\r\n"
				+ "   </div>\r\n"
				+ "    \r\n"
				+ "    <footer>\r\n"
				+ "        <div class=\"container-fluid \"> \r\n"
				+ "           \r\n"
				+ "            <div class=\"row  ml-4 pt-2 social\">\r\n"
				+ "                 <small class=\"pt-2\">Let's Connect with Each other</small>\r\n"
				+ "                <a href=\"#\" class=\"pl-4 pr-2\"><i class=\"fab fa-instagram\"></i></a>\r\n"
				+ "                <a href=\"#\" class=\"pl-1 pr-2\"><i class=\"fab fa-facebook\"></i></a>\r\n"
				+ "                <a href=\"#\" class=\"pl-1 pr-2\"><i class=\"fab fa-twitter\"></i></a>\r\n"
				+ "                <a href=\"#\" class=\"pl-1 pr-2\"><i class=\"fab fa-github\"></i></a>\r\n"
				+ "\r\n"
				+ "                <div class=\"sub\">\r\n"
				+ "                    <input class=\"mt-3 p-1\" type=\"text\" placeholder=\"Enter your Email\"><br>\r\n"
				+ "                    <label class=\"pl-1 pt-1\">Subscribe For More</label>\r\n"
				+ "                    <i class=\"fa fa-paper-plane p py-2   pl-3\"></i>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "\r\n"
				+ "            <div class=\"row ml-4 pt-3 pb-5\" style=\"opacity: 0.5;\">\r\n"
				+ "                @ All the Copywrites are Reserved and being Issued .\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "     </footer>\r\n"
				+ "     \r\n"
				+ "</body>");
	}

}
