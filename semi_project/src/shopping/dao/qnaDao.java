package shopping.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import shopping.dto.QAboardDTO;


public class qnaDao {
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
