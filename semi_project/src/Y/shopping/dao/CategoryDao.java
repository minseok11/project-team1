package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.CategoryDTO;
import jdbc.util.jdbcUtil;

public class CategoryDao {
	public int insert(CategoryDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into category values(?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getCategoryList());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int delete(String category){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="delete from category where categorylist=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, category);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<CategoryDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from category";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<CategoryDTO> list=new ArrayList<>();
			while(rs.next()){
				CategoryDTO dto=new CategoryDTO(rs.getString("categoryList"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
}
