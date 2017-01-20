package Hwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import Hwang.dto.BasketDto;
import Hwang.dto.IIDTO;
import shopping.dto.InterestDTO;

public class InterestDao {

	public ArrayList<IIDTO> IdList(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select price,name,itemimgroot,n.code from interest n,item i where n.code=i.code and id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			ArrayList<IIDTO> list=new ArrayList<>();
			rs=pst.executeQuery();
			while(rs.next()){
				IIDTO dto=new IIDTO(
						rs.getInt("price"),
						rs.getString("name"),
						rs.getString("itemimgroot"),
						rs.getString("code")
					);
				list.add(dto);
			}
			return list;		
		}catch(SQLException se){
			System.out.println(se.getMessage());	
			return null;
		}finally{
			jdbcUtil.close(rs, pst, con);
		}
	}

	public int insert(Hwang.dto.InterestDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into interest values(?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getCode());
			pst.setString(2, dto.getId());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
	public int delete(Hwang.dto.InterestDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			
			System.out.println(dto.getId()+ "," +dto.getCode());
			String sql="delete interest where id=? and code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getCode());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
}
