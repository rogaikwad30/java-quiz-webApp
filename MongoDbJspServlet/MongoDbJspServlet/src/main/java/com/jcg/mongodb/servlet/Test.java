package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Test extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String[] t = (String[]) req.getAttribute("q");
	    //System.out.println("list Size " +   t.length );
		String [] Qarr , CAarr , Aarr , Barr ,Carr = new String[t.length];

		
		Qarr = (String[]) req.getAttribute("q");
		CAarr = (String[]) req.getAttribute("ca");
		Aarr = (String[]) req.getAttribute("a");
		Barr = (String[]) req.getAttribute("b");
		Carr = (String[]) req.getAttribute("c");
		String id = (String) req.getAttribute("id");
	 	System.out.println("done ");
		
	 	 PrintWriter out = resp.getWriter();
	 	 out.println("<!DOCTYPE html>\r\n"
	 	 		+ "<html lang=\"en\">\r\n"
	 	 		+ "<head>\r\n"
	 	 		+ "    <meta charset=\"UTF-8\">\r\n"
	 	 		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	 	 		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\">\r\n"
	 	 		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n"
	 	 		+ "    <link rel=\"stylesheet\" href=\"./css/attemptQuiz.css\">\r\n"
	 	 		+ "    <link rel=\"stylesheet\" href=\"./css/dashBoard.css\">\r\n"
	 	 		+ "    <title>AttemptQuiz</title>\r\n"
	 	 		+ "</head>\r\n"
	 	 		+ "<body>"
	 	 		+ " <div class=\"navbar container-fluid\">\r\n"
	 	 		+ "        <div class=\"row icons my-1\">\r\n"
	 	 		+ "            <a href=\"#\" class=\"px-4 active text-center Link\" >\r\n"
	 	 		+ "                <i class=\"fas fa-atom mr-2 mb-2\"></i>\r\n"
	 	 		+ "                <b>Take a Quiz</b>\r\n"
	 	 		+ "            </a>\r\n"
	 	 		+ "            \r\n"
	 	 		+ "            <a href=\"DashBoard\" class=\"px-4    text-center Link\">\r\n"
	 	 		+ "                <i class=\"fas fa-home mr-2 mb-2\"></i>\r\n"
	 	 		+ "                <b>Home</b>\r\n"
	 	 		+ "            </a>\r\n"
	 	 		+ "         \r\n"
	 	 		+ "    \r\n"
	 	 		+ "           <a href=\"YourQuiz\" class=\" px-4   text-center Link\" >\r\n"
	 	 		+ "               <i class=\"fab fa-quinscape mr-2 mb-2\"></i>\r\n"
	 	 		+ "               <b>Create Quiz</b>\r\n"
	 	 		+ "           </a>\r\n"
	 	 		+ "           <a href=\"logout\" class=\" px-4  float-right text-center Link\" >\r\n"
	 	 		+ "            <i class=\"fas fa-sign-out-alt mr-2 mb-2\"></i>\r\n"
	 	 		+ "            <b>SignOut</b>\r\n"
	 	 		+ "        </a>\r\n"
	 	 		+ "        </div>\r\n"
	 	 		+ "    </div>"
	 	 		+ " <div class=\"container qbox mt-4\">\r\n"
	 	 		         
	 	 		+ "        \r\n");
	 	 
	 	 out.println("<form action=\"submit\" method=\"POST\">");
	 	 
	 	 for(int i=0;i<Qarr.length;i++) {
	 		 
	 	
	 	 
	 	 		out.println(" <p class=\"row mb-5  \">\r\n"
	 	 		+ "            <div class=\"col-12 ques\">\r\n"
	 	 		+ (i+1) + " . "  +  Qarr[i] 
	 	 		+ "            </div>\r\n"
	 	 		+ "        </p>\r\n"
	 	 		+ "        <div class=\"row options\">\r\n"
	 	 		+ "            <div class=\"col-12\">\r\n"
	 	 		+ "                <input value=\"c\" name=\""+ i + "\" class=\"my-2 ml-5\" type=\"radio\">\r\n"
	 	 		+ "                <span class=\"pl-2\">"+ CAarr[i]  +"</span>\r\n"
	 	 		+ "            </div>\r\n"
	 	 		+ "            <div class=\"col-12\">\r\n"
	 	 		+ "                <input value=\"a\" name=\""+ i +"\" class=\"my-2 ml-5\" type=\"radio\">\r\n"
	 	 		+ "                <span class=\"pl-2\"> "+ Aarr[i] +"</span>\r\n"
	 	 		+ "            </div>\r\n"
	 	 		+ "            <div class=\"col-12\">\r\n"
	 	 		+ "                <input value=\"b\" name=\""+ i +"\" class=\"my-2 ml-5\" type=\"radio\">\r\n"
	 	 		+ "                <span class=\"pl-2\">"+ Barr[i] +"</span>\r\n"
	 	 		+ "            </div>\r\n"
	 	 		+ "            <div class=\"col-12\">\r\n"
	 	 		+ "                <input value=\"d\" name=\""+ i +"\" class=\"my-2 ml-5\" type=\"radio\">\r\n"
	 	 		+ "                <span class=\"pl-2\">"+ Carr[i] +"</span>\r\n"
	 	 		+ "            </div>\r\n"
	 	 		+ "        </div>\r\n"
	 	 		+ "\r\n"
	 	 		
	 	 		);
	 	 		
	 	 		
	 	 		
	 	 }	
	 	 
	 	 out.println("  <input type=\"text\" name=\"id\" readonly hidden value=\""+id+"\">");
	 	 out.println("<input type=\"submit\" class=\"mt-5 p-3 float-right btn btn-success\">");
	 	 out.println("</form>");
	 	 		out.println( "    </div>\r\n");
	 	 		
	 	 		
	 	 		
	 	 		
	 	 		out.println("<div class=\"jumbotron jbox\">\r\n"
	 	 		+ "\r\n"
	 	 		+ "\r\n"
	 	 		+ "\r\n"
	 	 		+ "    </div>"
	 	 		+ " <footer>\r\n"
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
	 	 		+ "</body>\r\n"
	 	 		+ "</html>"
	 	 		);
	}
}
