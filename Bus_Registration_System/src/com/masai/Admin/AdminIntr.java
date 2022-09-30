package com.masai.Admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exceptions.AdminException;
import com.masai.Exceptions.BusException;
import com.masai.Exceptions.TicketException;
import com.masai.bean.Bus;

;

public interface AdminIntr {

	public boolean login(String name,String password)throws AdminException;
	
	public List<Bus> showBus()throws BusException  ;
	
	public String registerbus(Bus b)throws BusException; 
	
	public List conformation(String b) throws TicketException; 
	
}
