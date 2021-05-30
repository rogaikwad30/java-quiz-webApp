package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class Submit extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 
		ObjectId id = new ObjectId(req.getParameter("id"));
	
		HashMap<String, String[]> Data =  Util.searchQuiz(id);
		int maxMarks = Data.get("Questions").length;
		System.out.println("max marks : " + maxMarks);
		
		int marks = 0; 
		for(int i=0;i<maxMarks ; i++) {
			String userAns = req.getParameter("" + i + "");
			
			if(userAns.equals("c") == true) {
				marks = marks +1;
			}
		}

		
		PrintWriter out = resp.getWriter();
		if(UserData.email != "") {
		    Util.addToTestGiven(id.toString(), UserData.email , marks);
		}
		else {
			System.out.println("obt marks not saved in db : " + marks);
				
		}
		
		renderPage(out,id.toString() , maxMarks , marks);
	 }	 

	 

	public void renderPage( PrintWriter out  , String id , int max , int min ) {  
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Result</title>\r\n"
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
				+ "                     \r\n"
				+ "                        <input class=\"col-10 mt-5 py-3 offset-1 \" placeholder=\""+ id + "\"  type=\"text\" name=\"id\" value=\"\" id=\"code\" readonly style=\"cursor: pointer;\">\r\n"
				+ "                        \r\n"
				+ "                        <input id=\"start\"  class=\"col-10 mt-5 mb-4 py-2 offset-1 btn btn-success\"   type=\"submit\" value=\"Result - "+ min +" / " + max +"\" readonly>\r\n"
				+ "                  \r\n"
				+ " \r\n"
				+ "\r\n"
				+ "                    \r\n"
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
