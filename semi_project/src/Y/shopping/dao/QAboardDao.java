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
			String sql="insert into qaboard values(seq,?,?,?,?,?)";
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
