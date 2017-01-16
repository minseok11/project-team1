package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import shopping.dto.BoardDTO;
import shopping.dto.QAboardDTO;

public class BoardDao {
	public int insert(BoardDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst1=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into board values(SEQ_BOARD_BOARDNUM.nextval,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getContent());
			pst.setString(3, dto.getId());
			pst.setString(4, dto.getCode());
			pst.setString(5, dto.getImgName());
			int a=pst.executeUpdate();
			return a;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
	public int getCount(String code){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select count(boardnum),code from board group by code having code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
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
	public ArrayList<BoardDTO> listUp(String code,int startNum,int endNum){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			
			String sql="select * from (select se.*,rownum r from (select * from board where code=? order by boardnum asc)se) where r>=? and r<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
			pst.setInt(2, startNum);
			pst.setInt(3, endNum);
			ArrayList<BoardDTO> list=new ArrayList<>();
			rs=pst.executeQuery();
			while(rs.next()){
				int boardNum=rs.getInt(1);
				String title=rs.getString(2);
				String content=rs.getString(3);
				String id=rs.getString(4);
				String imgName=rs.getString(6);
				BoardDTO dto=new BoardDTO(boardNum, title, content, id, code, imgName);
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
}
