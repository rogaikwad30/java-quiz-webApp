package com.jcg.mongodb.servlet;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bson.BasicBSONObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Util {

	// Method to make a connection to the mongodb server listening on a default port
	private static MongoClient getConnection() {
		int port_no = 27017;
		String url = "localhost";

		MongoClient mongoClntObj = new MongoClient(url, port_no);
		return mongoClntObj;
	}

	public static String createQuiz( String Q , String CA , String A , String B , String C , String testID) {
		String db_name = "test",
				db_collection_name = "quiz";

		MongoDatabase db = getConnection().getDatabase(db_name);
		
		 Document document = new Document();
	      document.append("que", Q);
	      document.append("corrAns", CA);
	      document.append("oA", A);
	      document.append("oB", B);
	      document.append("oC", C);
	      db.getCollection(db_collection_name).insertOne(document);
	      
	      ObjectId id =  (ObjectId) document.get( "_id" ); 
	      String code = "";
	      if(testID == null) {
	    	  code = createTest(null , id);
	      }
	      else {
	    	  ObjectId t = new ObjectId(testID);
		      code = createTest(t , id);
	      }
	      
		System.out.println("ques saved with ID : "+ id);
		return code;
		
		 
	}
	
	public static String createTest( ObjectId testID , ObjectId quesID) {
		String db_name = "test",
				db_collection_name = "final";
		MongoDatabase db = getConnection().getDatabase(db_name);
		
		if(testID != null) {
			ObjectId id = quesID;
			db.getCollection(db_collection_name).updateOne(eq("_id", testID), new Document("$push", new Document("quizzes", id)));
			 
			System.out.println("Check db for testID : " + testID);
			return testID.toString();
		
		}
		else {
			Document doc = new Document();
			ObjectId ids = quesID;
			BasicDBList list = new BasicDBList();
			list.add(ids);
			doc.append("quizzes", list);
			doc.append("author", UserData.email);
			db.getCollection(db_collection_name).insertOne(doc);
			ObjectId id = (ObjectId)doc.get( "_id" );
			System.out.println("test created  with ID : "+ id);
			
			
			
			
			if(UserData.email != "") {
				db.getCollection("users").updateOne(eq("email", UserData.email), new Document("$push", new Document("testCreated", id)));
			}
			else {
				System.out.println("no");
			}
			
			
			
			return id.toString();
		}
		
	}
	
	public static  HashMap<String, String[]> searchQuiz ( ObjectId testID ) {
		String db_name = "test",
				db_collection_name = "final",
				db_collection_quizz = "quiz";
		
		MongoDatabase db = getConnection().getDatabase(db_name);
		
		FindIterable<Document> obj = db.getCollection(db_collection_name).find(eq("_id", testID));
 
		 
		Object arr = new Document();
	      MongoCursor<Document> it = obj.iterator(); 
	      while (it.hasNext()) { 
	    	 arr = it.next().get("quizzes");   
	      }
	      ArrayList<ObjectId> list = new ArrayList<ObjectId>();
	      list = (ArrayList<ObjectId>) arr;
	      System.out.println("this ");
	      String[] Q = new String [list.size()];
	      String[] CA = new String [list.size()];
	      String[] A = new String [list.size()];
	      String[] B = new String [list.size()];
	      String[] C = new String [list.size()];
	      String[] ids = new String [list.size()];
	      for(int k=0; k<list.size();k++ ) {
	    	   
	    	  ObjectId id = list.get(k); 
	    	  FindIterable<Document> object = db.getCollection(db_collection_quizz).find(eq("_id", id));
	    	  
	    	  Document doc = new Document();
	    	   
	    	  
		      MongoCursor<Document> it_quiz = object.iterator(); 
		      while (it_quiz.hasNext()) { 
		    	 doc = it_quiz.next();
		      }
		     
		      Q[k] = (String) doc.get("que");
		      CA[k] = (String) doc.get("corrAns");
		      A[k] = (String) doc.get("oA");
		      B[k] = (String) doc.get("oB");
		      C[k] = (String) doc.get("oC");
		      ids[k] =  doc.get("_id").toString();
		     
	      }
	      HashMap<String, String[]> Data = new HashMap<String, String[]>();
	      Data.put("Questions", Q);
	      Data.put("Answers", CA);
	      Data.put("OptionA", A);
	      Data.put("OptionB", B);
	      Data.put("OptionC", C);
	      Data.put("ids", ids);
	      return Data;
	} 
	
	
	public static String registerUser( String email , String password , String name ) {

		String db_name = "test",
				db_collection_name = "users";

		MongoDatabase db = getConnection().getDatabase(db_name);
		
		FindIterable<Document> obj = db.getCollection(db_collection_name).find(eq("email", email));
		Object arr = new Document();
	      MongoCursor<Document> it = obj.iterator(); 
	      if(it.hasNext()) {
	    	  return  "Email is already taken .";
	      }
	      else {
	    	  Document document = new Document();
		      document.append("email", email);
		      document.append("password", password);
		      document.append("name", name);
		      
		     
		      
		      document.append("testGiven",  new BasicDBList() );
		      document.append("testCreated",   new BasicDBList() );
		      
		      
		      db.getCollection(db_collection_name).insertOne(document);
		      return email;
	      }

		
	}
	
	
	public static String searchUserInDb(String email, String password) {

		 
		String db_name = "test",
				db_collection_name = "users";

		MongoDatabase db = getConnection().getDatabase(db_name);
		
		FindIterable<Document> obj = db.getCollection(db_collection_name).find(eq("email", email));
		String arr = new String();
	      MongoCursor<Document> it= obj.iterator(), it2 = obj.iterator(); 
	      if(it.hasNext()) {
	    	; 
	 	      arr = it.next().get("password").toString() ;
	 	   
	 		
	    	  
	    	System.out.println("This is " +    arr + " " + password);
	    	  if(arr.equals(password) == true) {
	    		  
		 		     return email;
	    	  }
	    	  else {
	    		  return "invalid credentials";
	    	  }
	      }
	      else {
	    	  return "invalid credentials";
          }
		
	}
	
	
	public static ArrayList<ObjectId> getUserData(String email) {
		String db_name = "test",
				db_collection_name = "users";
		
		MongoDatabase db = getConnection().getDatabase(db_name);
		
		FindIterable<Document> obj = db.getCollection(db_collection_name).find(eq("email", email));
 
		 
		Object arr = new Document();
	      MongoCursor<Document> it = obj.iterator(); 
	      while (it.hasNext()) { 
	    	 arr = it.next().get("testCreated");   
	      }
	      ArrayList<ObjectId> list = new ArrayList<ObjectId>();
	      list = (ArrayList<ObjectId>) arr;
	      return list;
	}
	
	
	public static ArrayList<ObjectId> getUserAtemptedData(String email) {
		String db_name = "test",
				db_collection_name = "users";
		
		MongoDatabase db = getConnection().getDatabase(db_name);
		
		FindIterable<Document> obj = db.getCollection(db_collection_name).find(eq("email", email));
 
		 
		Object arr = new Document();
	      MongoCursor<Document> it = obj.iterator(); 
	      while (it.hasNext()) { 
	    	 arr = it.next().get("testGiven");   
	      }
	      ArrayList<ObjectId> list = new ArrayList<ObjectId>();
	      list = (ArrayList<ObjectId>) arr;
	      return list;
	}
	
	
	public static void addToTestGiven(String testID, String user , int marks ) {
		String db_name = "test";
		MongoDatabase db = getConnection().getDatabase(db_name);
		Document temp = new Document();
		temp.put("marks",marks );
		temp.put("testID", testID);
		Document temp2 = new Document();
		temp2.put("user", user );
		temp2.put("marks", marks);
		ObjectId i = new ObjectId(testID);
		db.getCollection("users").updateOne(eq("email", UserData.email), new Document("$push", new Document("testGiven", temp))); 
		db.getCollection("final").updateOne(eq("_id", i), new Document("$push", new Document("students", temp2))); 
		return ;
	}
	
	public static void deleteQues (ObjectId testid , ObjectId quesid) {
		String db_name = "test";
		MongoDatabase db = getConnection().getDatabase(db_name);
		

		db.getCollection("final").updateOne(eq("_id", testid), new Document("$pull", new Document("quizzes", quesid) ) );
		
	}
	
	 
	
	
	public static void getStudents (String id) {
		String db_name = "test";
		MongoDatabase db = getConnection().getDatabase(db_name); 
		
		ObjectId t = new ObjectId("60b3c38a5a3b8a478cf5753f");
		FindIterable<Document> obj = db.getCollection("final").find(eq("_id", t));
		 
		 ArrayList<Document> a = new ArrayList();
		 Object arr = new Document();
	      MongoCursor<Document> it = obj.iterator(); 
	      while (it.hasNext()) { 
	    	 arr = it.next();   
	    	 a.add((Document) arr);
	    	 System.out.println("Hi"+ a);
	      }
	      
	      
	      
	      
	}
	
	
}