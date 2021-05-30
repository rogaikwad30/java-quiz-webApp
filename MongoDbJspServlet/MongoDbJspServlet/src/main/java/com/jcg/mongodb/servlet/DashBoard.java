package com.jcg.mongodb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;


public class DashBoard extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public static String r = null;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
 	 	
		     if(UserData.email != "") {
		    	 ArrayList<ObjectId> data =  Util.getUserData(UserData.email);
		    	 ArrayList<ObjectId> data2 =  Util.getUserAtemptedData(UserData.email);
		    	 renderPage( out , UserData.email , data.size() , data2.size());
		     }
		     else {
		    	  out.println("You Need to login first");
		    	  return;
		     }
		    
		   
	 	 }	 

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
 	 	
		 if(UserData.email != "") {
	    	 ArrayList<ObjectId> data =  Util.getUserData(UserData.email);
	    	 ArrayList<ObjectId> data2 =  Util.getUserAtemptedData(UserData.email);
	    	 renderPage( out , UserData.email , data.size() , data2.size());
	     }
	     else {
	    	  out.println("You Need to login first");
	    	  return;
	     }
 	 		
 	 }	 

	public void renderPage( PrintWriter out , String Email , int data , int data2 ) { 
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>DashBoard</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" integrity=\"sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/navbar.css\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./css/dashBoard.css\">\r\n"
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
				+ "                <h4 class=\"brand\"><a href=\"#\" style=\"text-decoration: none; color: aliceblue; font-size: 24px;font-weight: bold; letter-spacing: 1.25px;\">"+ Email  + "</h4>\r\n"
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
				+ "        <div class=\"container mt-5 nos\" >\r\n"
				+ "            <div class=\"row\">\r\n"
				+ "                <div class=\"col-10 mb-5 offset-1 offset-md-0 col-md-5  p-5 number text-center bg-white\">\r\n"
				+ "                     <h3 class=\"row d-inline \" style=\"font-size: 33px;\">\r\n"
				+ "                       "+ data2 +"\r\n"
				+ "                     </h3>\r\n"
				+ "                     <p class=\"row pt-4\">\r\n"
				+ "                        \r\n"
				+ "                        <a href=\"attemptedQuizzes\" class=\"col-12 text-center\" style=\"font-size: 18px; font-weight: 500; text-decoration: none;\"> Attempted Quizzes\r\n"
				+ "                            <i class=\"fa fa-question pl-3\" style=\"font-size: 34px; color: rgb(199, 0, 73);\"></i>\r\n"
				+ "                           \r\n"
				+ "                        </a>\r\n"
				+ "                        <p class=\"lead px-5\">CLick on the link to see list of all quizzess attempted by you along with the result . </p>\r\n"
				+ "                     </p>\r\n"
				+ "                     \r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"col-10 my-5 offset-1 offset-md-2 col-md-5 p-5 number text-center bg-white\">\r\n"
				+ "                    <h3 class=\"row d-inline \" style=\"font-size: 33px;\">\r\n"
				+ "                       "+ data +"\r\n"
				+ "                    </h3>\r\n"
				+ "                    <p class=\"row pt-4\">\r\n"
				+ "                       \r\n"
				+ "                       <a href=\"CreatedQuizzes\" class=\"col-12 text-center\" style=\"font-size: 18px; font-weight: 500; text-decoration: none;\"> Created Quizzes\r\n"
				+ "                        \r\n"
				+ "                        <i class=\"far fa-angry pl-3\" style=\"font-size: 34px; color: rgb(78, 0, 120);\"></i>\r\n"
				+ "                           \r\n"
				+ "                       </a>\r\n"
				+ "                       <p class=\"lead pb-4 px-5\">CLick on the link to see list of all quizzess Created by you along with the deatils of participants who attempted quizzes</p>\r\n"
				+ "                    </p>\r\n"
				+ "                    \r\n"
				+ "               </div>\r\n"
				+ "\r\n"
				+ "               <div class=\"col-10 my-5 offset-1 offset-md-0 col-md-5  py-5 number  text-center bg-white\">\r\n"
				+ "                <h3 class=\"row\" style=\"font-size: 17px;\">\r\n"
				+ "                </h3>\r\n"
				+ "                <p class=\"row pt-4\">\r\n"
				+ "                   \r\n"
				+ "                   <a href=\"uniqueID\" class=\"col-12 text-center\" style=\"font-size: 18px; font-weight: 500; text-decoration: none;\"> Start this Quiz\r\n"
				+ "                    <i class=\"fas fa-arrows-alt pl-3\" style=\"font-size: 34px; color: rgb(92, 204, 0); \"></i>\r\n"
				+ "                     \r\n"
				+ "                   </a>\r\n"
				+ "                   <p class=\"lead pb-4 px-5\">Note :  Once you Enter the start button it will start the test directly</p>\r\n"
				+ "                </p>\r\n"
				+ "                \r\n"
				+ "               </div>\r\n"
				+ "\r\n"
				+ "               <div class=\"col-10 my-5 offset-1 offset-md-2 col-md-5  py-5 number  text-center bg-white\">\r\n"
				+ "                 \r\n"
				+ "                <p class=\"row pt-4\">\r\n"
				+ "                   \r\n"
				+ "                   <a href=\"YourQuiz\" class=\"col-12 text-center\" style=\"font-size: 18px; font-weight: 500; text-decoration: none;\"> Create a New Quiz\r\n"
				+ "                    <i class=\"fab fa-app-store-ios pl-3\" class=\"new\" style=\"font-size: 34px;color: rgba(255, 0, 0, 0.884);\"></i>\r\n"
				+ "                   </a>\r\n"
				+ "                   <p class=\"lead pb-4 px-5\">Note :  Create your own quizz with a unique ID</p>\r\n"
				+ "                </p>\r\n"
				+ "                \r\n"
				+ "               </div>\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "        \r\n"
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
