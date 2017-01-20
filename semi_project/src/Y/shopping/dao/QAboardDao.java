package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.QAboardDTO;
import jdbc.util.jdbcUtil;

public class QAboardDao {
	public int a_insert(QAboardDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into qaboard values(SEQ_QABOARD_NUM,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1,dto.getRefNum());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			pst.setString(4, dto.getId());
			pst.setString(5, dto.getQaList());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<QAboardDTO> listUp(String id,int startNum,int endNum){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			
			String sql="select * from (select se.*,rownum r from (select * from qaboard where id=? order by refnum desc,num asc)se) where r>=? and r<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setInt(2, startNum);
			pst.setInt(3, endNum);
			ArrayList<QAboardDTO> list=new ArrayList<>();
			rs=pst.executeQuery();
			while(rs.next()){
				int num=rs.getInt(1);
				int refNum=rs.getInt(2);
				String title=rs.getString(3);
				String content=rs.getString(4);
				String qaList=rs.getString(6);
				QAboardDTO dto=new QAboardDTO(num, refNum, title, content, id, qaList);
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
	public int getCount(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select count(num) from qaboard group by id having id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(rs, pst, con);
		}
	}
	public QAboardDTO SeeQA(int num){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from qaboard where num=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,num);
			rs=pst.executeQuery();
	
			if(rs.next()){
				QAboardDTO dto=new QAboardDTO(
						rs.getInt("num"),
						rs.getInt("refNum"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("id"),
						rs.getString("qaList"));
				return dto;
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public QAboardDTO SeeAnswer(int num){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from qaboard where refnum=? and id=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,num);
			pst.setString(2, "admin");
			rs=pst.executeQuery();
	
			if(rs.next()){
				QAboardDTO dto=new QAboardDTO(
						rs.getInt("num"),
						rs.getInt("refNum"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("id"),
						rs.getString("qaList"));
				return dto;
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<QAboardDTO> list(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from qaboard where id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			ArrayList<QAboardDTO> list=new ArrayList<>();
			while(rs.next()){
				QAboardDTO dto=new QAboardDTO(rs.getInt("num"),
						rs.getInt("refNum"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("id"),
						rs.getString("qaList"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<QAboardDTO> listAll(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from qaboard order by refnum desc";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<QAboardDTO> list=new ArrayList<>();
			while(rs.next()){
				QAboardDTO dto=new QAboardDTO(rs.getInt("num"),
						rs.getInt("refNum"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("id"),
						rs.getString("qaList"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
}
