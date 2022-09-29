package com.masai.Main;

import java.sql.Time;
import java.util.Scanner;

import com.masai.Admin.AdminIntr;
import com.masai.Admin.Adminimpl;
import com.masai.Exceptions.AdminException;

public class HRM {
	
	public static void selectOption() {
		Scanner sc =new Scanner(System.in);
		AdminIntr ad=new Adminimpl();
		
		System.out.println("\n Please Select option to continue: ");
		System.out.println("\n 1. Login As Admin.\n 2.Login As Customer");
		int ch=sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter username :");
			String username=sc.next();
			
			System.out.println("Enter Password");
			String password=sc.next();
		try {
			
			boolean ans=ad.login(username, password);
			if(ans) {
				System.out.println("Welcome To Admin:"+username);
				System.out.println("1 : add a new Bus");
				System.out.println("2 : update arrive time of Bus");
				
				System.out.println("3 : Search information about a Bus.");
				System.out.println("4 : Create Batch under a course");
				
				System.out.println("5 : Update total seats of a Bus.");
				
				System.out.println("6 : Exit");
				
				int adminch=sc.nextInt();
				
					switch (adminch) {
					case 1: {
						System.out.println("Enter Bus No:");
						int bno=sc.nextInt();
						String bname=sc.next();
						String broute=sc.next();
						String btype=sc.next();
						int seat=sc.nextInt();
						String arrivaltime=sc.next();
						String departuretime =sc.next();
						String date=sc.next();
						
						
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + adminch);
					}
				
			}
			
		} catch (AdminException e) {
			
			System.out.println(e.getMessage());
		}
			break;
			
		}
		case 2:{
			System.out.println("WElcome");
		}
		
		}
		
		
		
	}

}
