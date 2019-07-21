package com.ccx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ccx.model.PetType;
import com.ccx.util.StringUtil;

public class PetTypeDao {
public int add(Connection con,PetType petType) throws Exception{
		
		String sql="insert into t_pettype values(null,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,petType.getPetTypeName());

		return pstmt.executeUpdate();
	}
	/**
	 * 返回结果集
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception 
	 */
	public ResultSet list(Connection con,PetType petType) throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_pettype");
		if(StringUtil.isNotEmpty(petType.getPetTypeName())){
			sb.append(" and petTypeName like'%"+petType.getPetTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	/**
	 * 删除宠物类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exceptrion
	 */
	public int delete(Connection con,String id)throws Exception{
		
		String sql="delete from t_pettype where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
	/**
	 * 修改宠物类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exceptrion
	 */
	public int update(Connection con,PetType petType)throws Exception{
		
		String sql="update t_pettype set petTypeName=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,petType.getPetTypeName());
		pstmt.setInt(2,petType.getId());
		return pstmt.executeUpdate();
	}
}
