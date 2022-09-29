package com.masai.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Exceptions.AdminException;
import com.masai.bean.Bus;
import com.masai.utility.DBUtil;



public class Adminimpl implements AdminIntr {

	@Override
	public boolean login(String name, String password) throws AdminException {
try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement pst =conn.prepareStatement("select * from admin where username=? and password=?" );
			pst.setString(1, name);
			pst.setString(2, password);
			
			ResultSet rs=pst.executeQuery();
		System.out.println(rs);
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
	public Bus showBus(Bus b) throws SQLException {
		try(Connection con=DBUtil.provideConnection()){
			
			PreparedStatement pst=con.prepareStatement("select * from bus");
			
		}
		return null;
	}
}

