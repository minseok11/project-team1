package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.CustomerInfoDTO;
import jdbc.util.jdbcUtil;

public class CustomerInfoDao {
	public ArrayList<CustomerInfoDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from customerinfo";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<CustomerInfoDTO> list=new ArrayList<>();
			while(rs.next()){
				CustomerInfoDTO dto=new CustomerInfoDTO(rs.getString("id"),
						rs.getString("password"),
						rs.getString("qesList"),
						rs.getString("ans"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phoneNo"),
						rs.getString("adress"),
						rs.getString("postNo"));
				System.out.println(rs.getString("id"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<CustomerInfoDTO> userlist(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from customerinfo where id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			ArrayList<CustomerInfoDTO> list=new ArrayList<>();
			if(rs.next()){
				CustomerInfoDTO dto=new CustomerInfoDTO(rs.getString("id"),
						rs.getString("password"),
						rs.getString("qesList"),
						rs.getString("ans"),
						rs.getString("name"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phoneNo"),
						rs.getString("adress"),
						rs.getString("postNo"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
}
