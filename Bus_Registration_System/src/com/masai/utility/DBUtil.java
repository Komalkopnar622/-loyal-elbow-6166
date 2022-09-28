package com.masai.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provideConnection() {
		Connection con=null;
		
		String url="jdbc:mysql://localhost:3307/SuperFast";
		
		try {
			con=DriverManager.getConnection(url,"root","root");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}

}
