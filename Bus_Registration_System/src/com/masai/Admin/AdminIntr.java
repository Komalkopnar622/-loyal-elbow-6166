package com.masai.Admin;

import java.sql.SQLException;
import java.util.ArrayList;

import com.masai.Exceptions.AdminException;
import com.masai.bean.Bus;

;

public interface AdminIntr {

	public boolean login(String name,String password)throws AdminException;
	
	public Bus showBus(Bus b) throws SQLException;
	
}
