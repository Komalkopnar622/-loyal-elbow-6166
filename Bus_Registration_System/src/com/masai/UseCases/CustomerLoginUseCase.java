package com.masai.UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.Customer;
import com.masai.bean.CustomerDTO;
import com.masai.utility.DBUtil;

public class CustomerLoginUseCase {
	
	public String UpdateSeat(int bno,int seat) {
		String message="Hello";
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement
					("UPDATE Bus SET seat=? Where  busNo=?");
			ps.setInt(1, seat);
			ps.setInt(2, bno);
		int x=ps.executeUpdate();
		if(x>0) {
			System.out.println("Updated Sucessfully");
		}
		else {
			System.out.println("Not Updated");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public static List<CustomerDTO> avalibleTicket() {
		int total=0;
		List<CustomerDTO> d=new ArrayList();
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement
					("select bus_no, custer_id,sum(noof_ticket) from Ticket_book  GROUP BY  bus_No");
		
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			int bN=rs.getInt("bus_no");
			int cid=rs.getInt("custer_id");
			int sum=(rs.getInt("sum(noof_ticket)"));
			
			PreparedStatement ps1= conn.prepareStatement
					("select seat from bus where  busNo=?");
			ps1.setInt(1, bN);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()) {
				int seat=rs1.getInt("seat");
				 total=seat-sum;
				 
				 CustomerDTO cd=new CustomerDTO(bN,total);
				 d.add(cd);
						
			}
		
				
			}
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
		return d;
	}
	
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
