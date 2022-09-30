package com.masai.Main;

import java.sql.Date;
import java.sql.SQLException;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Admin.AdminIntr;
import com.masai.Admin.Adminimpl;
import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;
import com.masai.UseCases.CustomerLoginUseCase;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.bean.CustomerDTO;

import BusDAO.BusImpl;
import BusDAO.BusIntr;

public class HRM {
	static int count=1;
	static SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
	public static void selectOption() throws BusException, TicketException {
		Scanner sc =new Scanner(System.in);
		AdminIntr ad=new Adminimpl();
		BusIntr bs=new BusImpl();
		
		System.out.println("\n Please Select option to continue: ");
		System.out.println("\n 1. Login As Admin.\n 2.Login As Customer.\n 3.Signup As Customer");
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
				System.out.println("2 : Show all buses:");
				System.out.println("3 : Contact persons details after confirmation of the seat");
				System.out.println("4 : confirmation of the seat to the Customer");
				System.out.println("5 :exit()");
				
				int x=sc.nextInt();
				while(x !=5) {
					if(x==1) {
						System.out.println("Enter Bus No:");
						int bno=sc.nextInt();
						System.out.println("Enter Bus Name:");
						String bname=sc.next();
						System.out.println("Enter Bus Route:");
						String broute=sc.next();
						System.out.println("Enter Bus Type(Ac/NonAC):");
						String btype=sc.next();
						System.out.println("Enter Seat in Bus:");
						int seat=sc.nextInt();
						
//						System.out.println("Enter departure Time:");
//						 
//						String departuretime =sc.next();
//						LocalTime lt=LocalTime.parse(departuretime);
//						System.out.println("Enter Arrive Time:");
//						String arrivaltime=sc.next();
//						LocalTime la=LocalTime.parse(arrivaltime);
						
						
//				       LocalDate date=LocalDate.now();
				        
				        	
				        Bus bus= new Bus();
						bus.setBusNo(bno);
						bus.setBusname(bname);
						bus.setBusRoute(broute);
						bus.setBusType(btype);
						bus.setSeat(seat);
//						bus.setDate(date);
						
					String result=	ad.registerbus(bus);
					System.out.println(result);
						
					}
					else if(x==2) {
						List<Bus> l1=ad.showBus();
						l1.forEach(b ->{
							
							System.out.println("Bus No is :"+b.getBusNo());
							System.out.println("Bus Name is: "+b.getBusname());
							System.out.println("Bus Route is: "+b.getBusRoute());
							System.out.println("Bus Type is: "+b.getBusType());
							System.out.println("Bus Seat is: "+b.getSeat());
							System.out.println("Bus departure Time is: "+b.getDeparturetime());
							System.out.println("Bus arrive Time is: "+b.getArriveTime());
							System.out.println("Bus Date Time is: "+b.getDate());
							
							System.out.println("=======================");
						});
						
					}
					else if(x==3) {
						
						System.out.println("Enter bus name:");
						String b=sc.next();
						List<CustomerDTO> l1=ad.conformation(b);
						
						
						l1.forEach(cb->{
							System.out.println("Bus No is :"+cb.getBno());
							System.out.println("Bus Name is: "+cb.getBusname());
							int total=cb.getSeat()-count;
							System.out.println("Avalibale  Seat is: "+total);
							System.out.println("Customer Name is: "+cb.getCn());
							System.out.println("Cutomer Address is: "+cb.getA());
							System.out.println("Customer Mobile is: "+cb.getM());
							count++;
						});

						
					}
					else if(x==4) {
						
					}
					else {
						System.out.println("Please select a valid option.");
						
					}
					System.out.println("Welcome To Admin:"+username);
					System.out.println("1 : add a new Bus");
					System.out.println("2 : Show all buses:");
					System.out.println("3 : Contact persons details after confirmation of the seat");
					System.out.println("4 : confirmation of the seat to the Customer");
					System.out.println("5 :exit()");
					 x=sc.nextInt();
				}
			
			}
			
		} catch (AdminException e) {
			
			System.out.println(e.getMessage());
		}
			break;
			
		}
		//Customer Login
		case 2:{
			System.out.println("Welcome:");
			System.out.println("1. Register As Customer.");
			System.out.println("2 : See all available Bus list.");
			System.out.println("3 : Book  ticket by selecting Source and destination");
			System.out.println("4 : cancel ticket");
			System.out.println("5 :Exit() ");
			int num=sc.nextInt();
			
			
			while(num !=5) {
				if(num==1) {
					System.out.println("Enter Customer id:");
					int id=sc.nextInt();
					System.out.println("Enter Customer Name");
					String name=sc.next();
					System.out.println("Enter Customer Address");
					String add=sc.next();
					System.out.println("Enter Customer Mobile Number");
					String mob=sc.next();
					System.out.println("Enter Source");
					String s=sc.next();
					System.out.println("Enter Destination.");
					String d=sc.next();
					Customer c=new Customer(id,name,add,mob,s,d);
					CustomerLoginUseCase cl=new CustomerLoginUseCase();
					String str=cl.LoginCustomer(c);
					System.out.println(str);
				}
	
			else if(num==2) {
					
					List<Bus> l1=ad.showBus();
					l1.forEach(b ->{
						
						System.out.println("Bus No is :"+b.getBusNo());
						System.out.println("Bus Name is: "+b.getBusname());
						System.out.println("Bus Route is: "+b.getBusRoute());
						System.out.println("Bus Type is: "+b.getBusType());
						System.out.println("Bus Seat is: "+b.getSeat());
						System.out.println("Bus departure Time is: "+b.getDeparturetime());
						System.out.println("Bus arrive Time is: "+b.getArriveTime());
						System.out.println("Bus Date Time is: "+b.getDate());
						
						System.out.println("=======================");
					});
				}
				else if(num==2){
				
					System.out.println("Enter Source:");
					String source=sc.next();
					System.out.println("Enter Destination");
					String des=sc.next();
					System.out.println("Enter Customer Id:");
					int cid=sc.nextInt();
					System.out.println("Enter BusNo:");
					int bno=sc.nextInt();
					String ans=bs.bookTicket(source, des, cid, bno);
					System.out.println(ans);
					
				}
				else if(num==3) {
					System.out.println("Enter Customer_id");
					int id=sc.nextInt();
					bs.cancleTicket(id);
					
				}
				else if(num==4) {
					
				}
				else {
				System.out.println("please select a valid option");	
				
				}//end else
				System.out.println();
				System.out.println("1. Register As Customer.");
				System.out.println("2 : See all available Bus list.");
				System.out.println("3 : Book  ticket by selecting Source and destination");
				System.out.println("4 : cancel ticket");
				System.out.println("5 :Exit() ");
				 num=sc.nextInt();
				
				
			}//end While loop
		
					
		}
		
		}
		
		
		
	}

}
