package com.ccx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author 逆风
 *
 */

public class DbUtil {

	private static String dbUrl="jdbc:mysql://localhost:3306/db_petshop?useUnicode=true&characterEncoding=UTF-8";
	private static String dbUsername="root";
	private static String dbPassword="123456";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		return con;		
	}
	
	public void closeCon(Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接数据库成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接数据库失败！");
		}
	}
	
}
