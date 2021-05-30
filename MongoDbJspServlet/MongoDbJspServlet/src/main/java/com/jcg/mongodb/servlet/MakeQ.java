package com.jcg.mongodb.servlet;

public class MakeQ {
	public String q , ca , A ,B , C;
	public MakeQ() {
		q = ca = A = B = C = new String("Not Provided");
	}
	public MakeQ(String Q , String CA ,String AA , String BB , String CC) {
		q = Q;
		ca = CA;
		A = AA ;
		B = BB;
		C = CC;
	}
}
