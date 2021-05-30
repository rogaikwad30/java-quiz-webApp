package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static String r = null;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		    String email = req.getParameter("email") , password =   req.getParameter("password") , name =  req.getParameter("name") ;
		    PrintWriter out = resp.getWriter();
		    String user = Util.registerUser(email, password, name);
		    if(user == "Email is already taken .")
 	        renderPage(out , user);
		    else {
		    	UserData.email = user;
		    	RequestDispatcher rd =  req.getRequestDispatcher("DashBoard");
				rd.forward(req,resp);
		    }
	 	 }	 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 
 	    PrintWriter out = resp.getWriter();
 	    renderPage(out , "");
 	 		
 	 }	 

	public void renderPage( PrintWriter out , String user ) { 
		
		System.out.println();
		
		 out.println("<!DOCTYPE html>\r\n"
		 		+ "<html lang=\"en\">\r\n"
		 		+ "<head>\r\n"
		 		+ "    <meta charset=\"UTF-8\">\r\n"
		 		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		 		+ "    <title>Register</title>\r\n"
		 		+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\">\r\n"
		 		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n"
		 		+ "    <link rel=\"stylesheet\" href=\"./css/navbar.css\">\r\n"
		 		+ "    <link rel=\"stylesheet\" href=\"./css/login.css\">\r\n"
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
		 		+ "                <h1 class=\"brand\"><a href=\"home.html\">Quiz<span>zes</span>tra</a></h1>\r\n"
		 		+ "                <ul>\r\n" + 
		 		
		 		" <li><a href=\"dashBoard.html\" class=\"link\">Home</a></li>\r\n"
		 		+ "                    <li><a href=\"dashBoard.html#cbox\" class=\"link\">Services</a></li>\r\n"
		 		+ "                    <li><a href=\"register\" class=\"link\">Register</a></li>\r\n"
		 		+ "                    <li><a href=\"login\" class=\"link\">Login</a></li>"
		 		
		 		
		 		
		 		
		 		 
		 		+ "                </ul>\r\n"
		 		+ "            </nav>\r\n"
		 		+ "        </div>\r\n"
		 		+ "        <div class=\"login-form mb-5\" >\r\n"
		 		+ "            <form action=\"/MongoDbJspServlet/register\" method=\"post\">\r\n"
		 		+ "                <div class=\"avatar\"><i class=\"material-icons\">&#xE7FF;</i></div>\r\n"
		 		+ "                <h4 class=\"modal-title\">Create  Your Account</h4>\r\n"
		 		+ "                <div class=\"form-group\">\r\n"
		 		+ "                    <input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Your Name\" required=\"required\">\r\n"
		 		+ "                </div>\r\n"
		 		+ "                \r\n"
		 		+ "                <div class=\"form-group\">\r\n"
		 		+ "                    <input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Your email\" required=\"required\">\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <div class=\"form-group\">\r\n"
		 		+ "                    <input type=\"password\" class=\"form-control\" placeholder=\"Password\" name=\"password\" required=\"required\">\r\n"
		 		+ "                    <span class=\"d-block px-2 mt-4\" style=\"opacity: 0.5;\">Password Must have at least 1 smallcase , 1 uppercase ,1 digit and 1 symbol</span>\r\n"
		 		+ "                </div>\r\n");
		 		
		 		if(user != "") {
		 			out.println("                <div class=\"form-group\">\r\n"
					 		+ "                    <span class=\"d-block px-2 mt-4\" style=\"opacity: 0.5;\">"+ user  +"</span>\r\n"
					 		+ "                </div>\r\n");
		 		}
		 		
		 		
		 		out.println( "                <div class=\"form-group small clearfix\"> \r\n"
		 		+ "                    <a href=\"login\" class=\"forgot-link\" style=\"text-decoration: none;\">Login Here ....!</a>\r\n"
		 		+ "                </div>\r\n"
		 		+ "                <input type=\"submit\" class=\"btn btn-primary btn-block btn-lg\" value=\"Register\">\r\n"
		 		+ "            </form>\r\n"
		 		+ "        </div>\r\n"
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
