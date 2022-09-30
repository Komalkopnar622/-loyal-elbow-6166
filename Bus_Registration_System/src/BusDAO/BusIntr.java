package BusDAO;

import java.util.ArrayList;

import com.masai.Exceptions.BusException;



public interface BusIntr {
	public ArrayList<String> SeeAvaliable()throws BusException;
	
	public String bookTicket(String source,String destination,int cid,int busno);
	
	public String cancleTicket(int bus_no);

}
