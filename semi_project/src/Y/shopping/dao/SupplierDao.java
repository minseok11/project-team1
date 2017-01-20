package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.CategoryDTO;
import Y.shopping.dto.SupplierDTO;
import jdbc.util.jdbcUtil;

public class SupplierDao {
	public int insert(SupplierDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="INSERT INTO SUPPLIER VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getSupplier());
			pst.setString(2, dto.getManager());
			pst.setString(3, dto.getContect());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int delete(String supplier){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="DELETE FROM SUPPLIER WHERE SUPPLIER=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, supplier);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int update(SupplierDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="update supplier set manager=? , contect=? where supplier=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getManager());
			pst.setString(2, dto.getContect());
			pst.setString(3, dto.getSupplier());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<SupplierDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from Supplier";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<SupplierDTO> list=new ArrayList<>();
			while(rs.next()){
				SupplierDTO dto=new SupplierDTO(rs.getString("supplier"),
						rs.getString("manager"),
						rs.getString("contect"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<SupplierDTO> supplierList(String supplier){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from supplier where supplier=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, supplier);
			rs=pst.executeQuery();
			ArrayList<SupplierDTO> list=new ArrayList<>();
			if(rs.next()){
				SupplierDTO dto=new SupplierDTO(rs.getString("supplier"),
						rs.getString("manager"),
						rs.getString("contect"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
}
