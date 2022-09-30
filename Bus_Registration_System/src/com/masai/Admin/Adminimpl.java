package com.masai.Admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;
import com.masai.bean.Bus;
import com.masai.bean.Customer;
import com.masai.bean.CustomerDTO;
import com.masai.utility.DBUtil;



public class Adminimpl implements AdminIntr {

	@Override
	public boolean login(String name, String password) throws AdminException {
try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement pst =conn.prepareStatement("select * from admin where username=? and password=?" );
			pst.setString(1, name);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
		
			if(rs.next()) {
			
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			throw new AdminException(e.getMessage());
			
		}
	}

	@Override
	public List<Bus> showBus() throws BusException   {
		List<Bus> bus= new ArrayList<>();

		
		try(Connection con=DBUtil.provideConnection()){
			
			PreparedStatement pst=con.prepareStatement("select * from bus");
			ResultSet rs=pst.executeQuery();
			
				while(rs.next()) {
						int bno= rs.getInt("busNo");
						String bname= rs.getString("busName");
						String r= rs.getString("busRoute");
						String t= rs.getString("busType");
						int s= rs.getInt("seat");
//						Time dtime= rs.getTime("departuretime");
//								
//						Time atime= rs.getTime("arrivalTime");
//						Date date= rs.getDate("date");
								
						
					Bus busobj=new Bus(bno, bname, r, t, s);	
					bus.add(busobj);
					}
				} catch (SQLException e) {
					throw new BusException(e.getMessage());
				}
				if(bus.size() == 0)
					throw new BusException("No bus found..");
		return bus;
	}

	@Override
	public String registerbus(Bus b) throws BusException {
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement
					("insert into Bus(busNo,busName,busRoute,busType,seat) values(?,?,?,?,?)");
			
			ps.setInt(1, b.getBusNo());
			ps.setString(2, b.getBusname());
			ps.setString(3, b.getBusRoute());
			ps.setString(4, b.getBusType());
			ps.setInt(5, b.getSeat());
			
//			ps.setTime(6, b.getArriveTime());
//			ps.setTime(7, b.getDeparturetime());
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Bus Registered Sucessfully !";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<CustomerDTO> conformation(String busname) throws TicketException {
		List<CustomerDTO> l1=new ArrayList();
		Customer c=new Customer();
		Bus b=new Bus();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("select b.busNo, b.busName,b.seat, c.cname, c.address,c.mobile "
					+ "from  bus b INNER JOIN customer c INNER JOIN Ticket_book tb "
					+ "ON b.busNo = tb.bus_no AND c.cid = tb.custer_id");
//			ps.setString(1, busname);
			
			ResultSet rs= ps.executeQuery();
			System.out.println("Hello");
			
			while(rs.next()) {
				int bn= rs.getInt("busNo");
				String busn= rs.getString("busName");
				int seat=rs.getInt("seat");
				String cn= rs.getString("cname");
				String m= rs.getString("mobile");
				String a= rs.getString("address");
				
			
				CustomerDTO cd=new CustomerDTO(bn,busn,seat,cn,m,a);
				
				l1.add(cd);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(l1.isEmpty())
			throw new TicketException("No Customer found in that bus");
		
		return l1;

		
	}
	


	}


