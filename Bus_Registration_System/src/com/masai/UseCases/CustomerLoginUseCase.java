package com.masai.UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.utility.DBUtil;

public class CustomerLoginUseCase {
	
	public String LoginCustomer(Customer c){
		
		String message="Customer not register successfully. ";
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement
					("insert into Customer values(?,?,?,?,?,?)");
			
			ps.setInt(1, c.getCid());
			ps.setString(2, c.getCname());
			ps.setString(3,c.getAddress());
			ps.setString(4, c.getMobile());
			ps.setString(5, c.getSource());
			ps.setString(6, c.getDestination());

			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Customer Registered Sucessfully !";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
		
		
		
		
	}

}
