package com.masai.utility;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		   
		Connection con= DBUtil.provideConnection();
			
		if(con !=null) {
			System.out.println("Connected Sucessfully");
		}

	}

}
