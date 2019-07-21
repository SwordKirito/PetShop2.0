package com.ccx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ccx.model.Pet;
import com.ccx.util.StringUtil;

public class PetDao {
	/**
	 * 宠物添加
	 * @param con
	 * @param Pet
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Pet pet)throws Exception{
		//这个可以写有参构造，不要id，就方便了，以后多注意吧
		String sql="insert into t_pet values(null,?,?,?)";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, pet.getPetName());
		pstmt.setInt(2, pet.getPetTypeId());
		pstmt.setString(3, pet.getPetColor());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 宠物信息查询
	 * @param con
	 * @param Pet
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Pet pet)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_pet p,t_pettype pt where p.petTypeId=pt.id");
		if(StringUtil.isNotEmpty(pet.getPetName())){
			sb.append(" and p.petName like '%"+pet.getPetName()+"%'");
		}
		if(pet.getPetTypeId()!=0 && pet.getPetTypeId()!=-1){
			sb.append(" and p.petTypeId="+pet.getPetTypeId());
		}
		if(StringUtil.isNotEmpty(pet.getPetColor())){
			sb.append(" and p.petColor like '%"+pet.getPetColor()+"%'");
		}
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 宠物信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_pet where id=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 宠物信息修改
	 * @param con
	 * @param Pet
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Pet pet)throws Exception{
		String sql="update t_pet set PetName=?,PetTypeId=?,PetColor=? where id=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		
		pstmt.setString(1, pet.getPetName());
		pstmt.setInt(2, pet.getPetTypeId());
		pstmt.setString(3, pet.getPetColor());
		pstmt.setInt(4, pet.getId());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 
	 * @param con
	 * @param PetTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existPetByPetTypeId(Connection con,int petTypeId)throws Exception{
		String sql="select * from t_pet where PetTypeId=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		//我记错了，是getXX();
		pstmt.setInt(1, petTypeId);
		//this is can do .
		//在打完pstmt.executeQuery();后
		//按alt +shift+ L然后修改下变量name。
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
	
	
	//pstmt.setString(1, PetTypeId);
	//类似这种，是不是可以写一个函数，根据参数直接调用
	//一直手打，有部分感觉很难受啊
}
