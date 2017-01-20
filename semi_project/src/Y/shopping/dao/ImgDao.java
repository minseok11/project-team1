package Y.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.CustomerInfoDTO;
import Y.shopping.dto.ImgDTO;
import jdbc.util.jdbcUtil;

import java.sql.Connection;

public class ImgDao {
	public int insert(ImgDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into imgload values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getNickname());
			pst.setString(3, dto.getFilePath());
			pst.setString(4, dto.getFileName());
			int n=pst.executeUpdate();
			return n;
			
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<ImgDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from imgload";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<ImgDTO> list=new ArrayList<>();
			while(rs.next()){
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("nickname"));
				System.out.println(rs.getString("filePath"));
				System.out.println(rs.getString("fileName"));
				ImgDTO dto=new ImgDTO(rs.getString("name"),
						rs.getString("nickname"), 
						null,
						rs.getString("fileName"));
				list.add(dto);
			}
			System.out.println("리턴");
			return list;
		}catch(SQLException se){
			System.out.println("에러");
			System.out.println(se.getMessage());
			return null;
		}
	}
}
