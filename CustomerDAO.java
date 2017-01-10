package Hwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Hwang.dto.CustomerDTO;
import jdbc.util.JdbcUtil;

public class CustomerDAO {
	
		public boolean selectId(String id){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			boolean using=false;
			try{
				con=JdbcUtil.getConn();
				String sql="select * from CUSTOMERINFO where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					using=true;			
				}
				return true;
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return false;
			}finally{
				JdbcUtil.close(rs, pstmt, con);
			}
		}
	
		
		public int insert(CustomerDTO dto){
			Connection con=null;
			PreparedStatement pstmt=null;
			try{
				con=JdbcUtil.getConn();
				String sql="insert into CUSTOMERINFO values(?,?,?,?,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPassword());
				pstmt.setString(3, dto.getQeslist());
				pstmt.setString(4, dto.getAns());
				pstmt.setString(5, dto.getName());
				pstmt.setString(6, dto.getGender());
				pstmt.setString(7, dto.getEmail());
				pstmt.setString(8, dto.getPhoneno());
				pstmt.setString(9, dto.getAdress());
				pstmt.setString(10, dto.getPostno());				
				int n=pstmt.executeUpdate();
				return n;
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return -1;
			}finally{
				JdbcUtil.close(null, pstmt, con);
			}			
		}
	}

