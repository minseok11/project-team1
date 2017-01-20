package Hwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Hwang.dto.CustomerDTO;
import jdbc.util.jdbcUtil;

public class CustomerDAO {
	
	public String FindPwd(String id ,String name, String email){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String pwd=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select password from CUSTOMERINFO where id=? and name=? and email=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			rs=pstmt.executeQuery();	
			if(rs.next()){
				pwd=rs.getString("password");				
			}
			return pwd;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			jdbcUtil.close(rs, pstmt, con);
		}
	}
	
		public String FindId(String name, String email){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String id=null;
			try{
				con=jdbcUtil.getConn();
				String sql="select * from CUSTOMERINFO where name=? and email=? ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,name);
				pstmt.setString(2,email);
				rs=pstmt.executeQuery();	
				if(rs.next()){
					id=rs.getString("id");				
				}
				return id;
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return null;
			}finally{
				jdbcUtil.close(rs, pstmt, con);
			}
		}
			
	
		public int IsMember(String pwd, String id){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			boolean using=false;
			try{
				con=jdbcUtil.getConn();
				String sql="select * from CUSTOMERINFO where id=? and password=? ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,id);
				pstmt.setString(2,pwd);
				rs=pstmt.executeQuery();	
				if(rs.next()){
					return 1;					
				}else{
					return 0;
				}
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return -1;
			}finally{
				jdbcUtil.close(rs, pstmt, con);
			}
		}
	
		public boolean selectEmail(String email){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			boolean using=false;//사용중인 상대인지 저장
			try{
				con=jdbcUtil.getConn();
				String sql="select * from CUSTOMERINFO where email=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, email);
				rs=pstmt.executeQuery();
				if(rs.next()){
					using=true;			
				}
				return using;
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return false;
			}finally{
				jdbcUtil.close(rs, pstmt, con);
			}
		}
		
		
		public boolean selectId(String id){
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			boolean using=false;//사용중인 상대인지 저장
			try{
				con=jdbcUtil.getConn();
				String sql="select * from CUSTOMERINFO where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()){
					using=true;			
				}
				return using;
			}catch(SQLException se){
				System.out.println(se.getMessage());
				return false;
			}finally{
				jdbcUtil.close(rs, pstmt, con);
			}
		}
	
		
		public int insert(CustomerDTO dto){
			Connection con=null;
			PreparedStatement pstmt=null;
			try{
				con=jdbcUtil.getConn();
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
				jdbcUtil.close(null, pstmt, con);
			}			
		}
	}

