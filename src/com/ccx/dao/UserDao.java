package com.ccx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ccx.model.User;

public class UserDao {
	public User UserLogin(Connection con,User user) throws SQLException{
		
		User resultUser=null;
		
		String sqlString="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sqlString);		
		pstmt.setString(1, user.getUserName());		
		pstmt.setString(2, user.getPassword());		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			
			resultUser=new User();
			
			resultUser.setPassword(rs.getString("password"));
			
			resultUser.setUserName(rs.getString("userName"));
			
			resultUser.setId(rs.getInt("id"));
		}
		
		return resultUser;
	}
}
