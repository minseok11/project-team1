package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import shopping.dto.CategoryDTO;
import shopping.dto.ItemDTO;

public class ItemDao {
	public int insert(ItemDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into item values(?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getCode());
			pst.setInt(2, dto.getPrice());
			pst.setInt(3, dto.getInventory());
			pst.setString(4, dto.getName());
			pst.setInt(5, dto.getRetailPrice());
			pst.setString(6, dto.getItemImgRoot());
			pst.setString(7, dto.getCategoryList());
			pst.setString(8, dto.getSupplier());
			System.out.println(dto.getItemImgRoot());
			System.out.println(dto.getCategoryList());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int delete(String code){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="delete from item where code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<ItemDTO> search(String option,String search){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="SELECT * FROM ITEM WHERE "+option+" LIKE '%"+search+"%'";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("categoryList"),
						rs.getString("supplier"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<ItemDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from item";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(rs.getString("code"),
							rs.getInt("price"), 
							rs.getInt("inventory"),
							rs.getString("name"), 
							rs.getInt("retailPrice"),
							rs.getString("itemImgRoot"),
							rs.getString("categoryList"),
							rs.getString("supplier"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<ItemDTO> mainList(int startNum,int endNum){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from(select a.*,rownum r from (select * from item)a) where r>=? and r<=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, startNum);
			pst.setInt(2, endNum);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList();
			while(rs.next()){
				String code=rs.getString(1);
				int price=rs.getInt(2);
				int inventory=rs.getInt(3);
				String name=rs.getString(4);
				int retailPrice=rs.getInt(5);
				String itemImgRoot=rs.getString(6);
				String categoryList=rs.getString(7);
				String supplier=rs.getString(8);
				ItemDTO dto=new ItemDTO(code, price, inventory, name, retailPrice, itemImgRoot, categoryList, supplier);
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
	public ArrayList<ItemDTO> cateList(int startNum,int endNum,String cate){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from(select a.*,rownum r from (select * from item where categorylist=?)a) where r>=? and r<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
			pst.setInt(2, startNum);
			pst.setInt(3, endNum);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList();
			while(rs.next()){
				String code=rs.getString(1);
				int price=rs.getInt(2);
				int inventory=rs.getInt(3);
				String name=rs.getString(4);
				int retailPrice=rs.getInt(5);
				String itemImgRoot=rs.getString(6);
				String categoryList=rs.getString(7);
				String supplier=rs.getString(8);
				ItemDTO dto=new ItemDTO(code, price, inventory, name, retailPrice, itemImgRoot, categoryList, supplier);
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
	public int getCount(String cate){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select count(code) from item group by categorylist having categorylist=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
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
}
