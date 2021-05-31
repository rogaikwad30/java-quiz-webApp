package com.jcg.mongodb.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class CreatedQuizzes extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	 
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		 if(UserData.email != null) {
			 ArrayList<ObjectId> list = Util.getUserData(UserData.email);
			 String []arr = new String[list.size()];
			 for(int i=0; i<list.size() ;i++) {
				 arr[i] = list.get(i).toString();
			 }
			 renderPage(out , arr);
		 }
		 else {
			 out.println("Need to login first");
		 }
 	 }	 

	 public void renderPage( PrintWriter out, String[] list  ) { 
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
	     		+ "        <div class=\"container\" style=\"margin-top: 100px;\">\r\n"
	     		+ "            <table class=\"table table-striped\" style=\"background: white;font-size: 14px;\">\r\n"
	     		+ "                <thead class=\"table-dark\">\r\n"
	     		+ "                  <tr>\r\n"
	     		+ "                    <th scope=\"col\">No</th>\r\n"
	     		+ "                    <th scope=\"col\">TESTID</th>\r\n"
	     		+ "                    <th scope=\"col\">Action</th>\r\n"
	     		+ "                  </tr>\r\n"
	     		+ "                </thead>\r\n"
	     		+ "                <tbody>\r\n");
	     		
	     		
	     		for(int i=0; i<list.length; i++ ) {
	     			
	     		
	     		out.println("                  <tr>\r\n"
	     		+ "                    <th scope=\"row\">"+i+"</th>\r\n"
	     		+ "                    <td>"+ list[i] +"</td>\r\n"
	     		+ "                    <td>\r\n"
	     		+ "                        <form action=\"details\" method=\"POST\">\r\n"
	     		+"                             <input type=\"text\" name=\"testid\" hidden required readonly value=\""+list[i] +"\">"
	     		+ "                            <input class=\"btn btn-success p-2\" type=\"submit\" value=\"See Details\">\r\n"
	     		+ "                        </form>\r\n"
	     		+ "                    </td>\r\n"
	     		+ "                  </tr>\r\n");
	     		
	     		}
	     		
	     		out.println("                </tbody>\r\n"
	     		+ "              </table>\r\n"
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
	     		+ "</html>\r\n"
	     );
	}

}
