package BusDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;
import com.masai.utility.DBUtil;

public class BusImpl  implements BusIntr{

	@Override
	public ArrayList<String> SeeAvaliable() throws BusException {
		ArrayList<String> l1=new ArrayList<>();
		try(Connection con=DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement(" select  cid,  cname,address,sum(seats) from Customer inner join bus where cn2=coursename group by coursenAme" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l1;
	}

	@Override
	public String bookTicket(String source, String destination,int cid,int busno,int ticket) {
		String message ="Ticket Not Booked.";
		try(Connection con=DBUtil.provideConnection()) {
			PreparedStatement ps= con.prepareStatement("select * from customer where cid =?");
			ps.setInt(1, cid);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps2= con.prepareStatement("select * from bus where busNo=? And  source=? AND destination=?");
				ps2.setInt(1, busno);
				ps2.setString(2, source);
				ps2.setString(3,destination);
				
		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) { 
		 			
		 			PreparedStatement ps3= con.prepareStatement("insert into Ticket_book values(?,?,?,?,?)");
		 			
		 			ps3.setInt(1, cid);
		 			ps3.setInt(2, busno);
		 			ps3.setInt(3, ticket);
		 			ps3.setString(4,source );
		 			ps3.setString(5, destination);
		 			
		 			int x= ps3.executeUpdate();
		 			if(x > 0) message = "Ticket Book  Sucessfully.. ";
		 			else throw new TicketException("Ticket not Book");

			 				
			 }

		 }
		}catch (SQLException e) {
			e.getMessage();
			
		} catch (TicketException e) {
			e.getMessage();
		}
		

		return message;
	
}

	@Override
	public String cancleTicket(int bus_no) {
		String message ="Ticket Not Cancle.";
		try(Connection con=DBUtil.provideConnection()) {
			
			PreparedStatement ps=con.prepareStatement("DELETE FROM Ticket_book WHERE custer_id=?");
			ps.setInt(1, bus_no);
			int x=ps.executeUpdate();
			if(x>0)
				
			System.out.println("Recored deleted Sucessfully");
			else {
				System.out.println("Not");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
