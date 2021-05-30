package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class YourQuiz extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static String r = null;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		    PrintWriter out = resp.getWriter();
 	        String q = req.getParameter("que") , ca = req.getParameter("CorrectAns") , a = req.getParameter("option1") , b = req.getParameter("option2"), c = req.getParameter("option3");
 		    String testId =  Util.createQuiz(q, ca, a, b, c , r); // null passed // value in 2nd
 		    
	 	 	renderPage( out , testId );
	 	 	
	 	 	r = testId;
	 	 	req.setAttribute("test", r);
	 	 		
	 	 }	 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		r = null;
 	    PrintWriter out = resp.getWriter();
 	    String testID = r ;
	 	renderPage( out , testID );
 	 		
 	 		
 	 }	 

	public void renderPage( PrintWriter out  , String testID ) { 
		//System.out.println("hdwge "+testID);
		if(testID == null) {
			testID = "Once you add 1 ques ID will be generated";
		}
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/createQuiz.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/dashBoard.css\">\r\n"
				+ "    <title>createQuiz</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"navbar container-fluid\">\r\n"
				+ "        <div class=\"row icons my-1\">\r\n"
				+ "            <a href=\"#\" class=\" px-4   text-center  active Link\" >\r\n"
				+ "                <i class=\"fab fa-quinscape mr-2 mb-2\"></i>\r\n"
				+ "                <b>Create Quiz</b>\r\n"
				+ "            </a>\r\n"
				+ "            <a href=\"DashBoard\" class=\"px-4    text-center Link\">\r\n"
				+ "                <i class=\"fas fa-home mr-2 mb-2\"></i>\r\n"
				+ "                <b>Home</b>\r\n"
				+ "            </a>\r\n"
				+ "            <a href=\"uniqueID\" class=\"px-4  text-center Link\" >\r\n"
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
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"row mt-5 mb-4\">\r\n"
				);
		
		
		out.println("<h5 style=\"color: rebeccapurple;\">TEST CODE :  <kbd class=\"p-2 m-2\"> " + testID  +"</kbd></h5> \r\n"
				);
		
		
		out.println("</div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "    <div class=\"container  \">\r\n"
				);
		
		
		out.println("<form action=\"YourQuiz" );
		
		
//		if(testID != "Once you add 1 ques ID will be generated")
//		      out.println("/" + testID   );
//		
//		
		
		out.println("\" method=\"POST\">\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "            <div class=\" col-10 col-md-8 col-lg-6\"><b>Enter Your Question Here</b> </div>\r\n"
				+ "            <input required class=\"p-2 col-10 col-md-8 col-lg-6 ml-3 mt-3\" type=\"text\" placeholder=\"Enter Question Here\" name=\"que\">\r\n"
				+ "\r\n"
				+ "            <div class=\"col-12 pt-3\"><b>Correct Answer for Question</b> </div>\r\n"
				+ "            <input required class=\"p-2 col-10 col-md-8 col-lg-6 ml-3 mt-3\" type=\"text\" placeholder=\"Enter Correct Answer\" name=\"CorrectAns\">\r\n"
				+ "\r\n"
				+ "            <div class=\"col-12 pt-3\"><b>Other Options</b> </div>\r\n"
				+ "            <input required class=\"p-2 col-10 col-md-8 col-lg-6 ml-3 mt-3\" type=\"text\" placeholder=\"Enter Incorrect Answer\" name=\"option1\">\r\n"
				+ "\r\n"
				+ "             \r\n"
				+ "            <input required class=\"p-2 col-10 col-md-8 col-lg-6 ml-3 mt-3\" type=\"text\" placeholder=\"Enter Incorrect Answer\" name=\"option2\">\r\n"
				+ "\r\n"
				+ "            <input required class=\"p-2 col-10 col-md-8 col-lg-6 ml-3 mt-3\" type=\"text\" placeholder=\"Enter InCorrect Answer\" name=\"option3\">\r\n"
				+ "            \r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				 
				+ "\r\n");
				
		

		 
				
				
				
				
				out.println("\r\n"
				+ "        <button type=\"submit\" class=\"btn btn-sm btn-success p-3 my-5 float-center\">\r\n"
				+ "            Save Question\r\n"
				+ "        </button>\r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "        \r\n"
				+ "      \r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "    \r\n"
				+ "    </form>\r\n"
				+ "    </div>\r\n" );
				
				

				out.println("<form class=\" m-5 p-5 pt-0 mt-0\" action=\"Preview\" method=\"POST\">\r\n"
						+ "        <input type=\"text\" name=\"code\" id=\"code\" value=\"" + testID + "\" required  style=\"display: none;\" > \r\n"
						+ "        <input type=\"submit\" class=\"btn float-right p-2 btn-secondary\" value=\"Preview Test\">\r\n"
						+ "    </form>");
				
				
				
			   out.println("    <footer>\r\n"
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
				+ "</body>\r\n"
				+ "</html>");
	}

}
