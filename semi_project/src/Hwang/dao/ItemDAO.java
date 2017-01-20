package Hwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shopping.dto.ItemDTO;
import jdbc.util.jdbcUtil;


public class ItemDAO {
	//카테고리의 검색한 단어의 갯수 뽑아오기
	public int ItemSearchCount(String search, String cate){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select count(code) from item where name like '%"+search+"%' and categorylist=? ";
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
	
	//검색한 단어를 포함한 리스트 뽑아오기(카테고리별)
	public ArrayList<ItemDTO> CateSearchList(String cate,String search, int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from (select aa.*,rownum rnum from(select * from item where categorylist=? and name like '%"+search+"%')aa) where rnum>=? and rnum<=?";			           
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cate);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			ArrayList<ItemDTO> list=new ArrayList<>();
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
						rs.getString("categoryList"),
						rs.getString("supplier"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			jdbcUtil.close(rs, pstmt, con);
		}
	}
		
	//검색한 단어를 포함한 리스트 뽑아오기
	public ArrayList<ItemDTO> MainSerchList(String search, int startRow, int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="SELECT * from (select aa.*,rownum rnum from(select * from item where name LIKE '%"+search+"%')aa) where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			ArrayList<ItemDTO> list=new ArrayList<>();
			rs=pstmt.executeQuery();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
						rs.getString("categoryList"),
						rs.getString("supplier"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			jdbcUtil.close(rs, pstmt, con);
		}
	}
	
	//메인 검색 전체글 수 
	public int SearchCount(String search){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select count(code) from item where name like '%"+search+"%' ";
			pst=con.prepareStatement(sql);
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
	
	
	public ArrayList<ItemDTO> HotItemList(String cate,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select pcode.*,categorylist from (select count(code),code from payment group by code)pcode,item i where i.code=pcode.code and i.categoryList=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
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
	
	public ArrayList<ItemDTO> HighPriceList(String cate,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from (select aa.*,rownum rnum from(select * from item where categorylist=? order by price desc)aa) where rnum>=? and rnum<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
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
	
	
	public ArrayList<ItemDTO> LowPriceList(String cate,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from (select aa.*,rownum rnum from(select * from item where categorylist=? order by price asc)aa) where rnum>=? and rnum<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(					
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
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
	
	
	public ArrayList<ItemDTO> NewItemList(String cate,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from (select aa.*,rownum rnum from(select * from item where categorylist=?)aa) where rnum>=? and rnum<=? order by rnum desc";
			pst=con.prepareStatement(sql);
			pst.setString(1, cate);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			while(rs.next()){
				ItemDTO dto=new ItemDTO(
						rs.getString("code"),
						rs.getInt("price"), 
						rs.getInt("inventory"),
						rs.getString("name"), 
						rs.getInt("retailPrice"),
						rs.getString("itemImgRoot"),
						rs.getString("detailImg"),
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

	

//----------------------------------------------------------------------------------------------------------------
	
	public int insert(ItemDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into item values(?,?,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getCode());
			pst.setInt(2, dto.getPrice());
			pst.setInt(3, dto.getInventory());
			pst.setString(4, dto.getName());
			pst.setInt(5, dto.getRetailPrice());
			pst.setString(6, dto.getItemImgRoot());
			pst.setString(7, dto.getDetailImg());
			pst.setString(8, dto.getCategoryList());
			pst.setString(9, dto.getSupplier());
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
						rs.getString("detailImg"),
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
							rs.getString("detailImg"),
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
				String detailImg=rs.getString(7);
				String categoryList=rs.getString(8);
				String supplier=rs.getString(9);
				ItemDTO dto=new ItemDTO(code, price, inventory, name, retailPrice, itemImgRoot,detailImg ,categoryList, supplier);
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
				String detailImg=rs.getString(7);
				String categoryList=rs.getString(8);
				String supplier=rs.getString(9);
				ItemDTO dto=new ItemDTO(code, price, inventory, name, retailPrice, itemImgRoot,detailImg, categoryList, supplier);
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

	public ItemDTO itemDetail(String code){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from item where code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
			rs=pst.executeQuery();
			if(rs.next()){
				int price=rs.getInt(2);
				int inventory=rs.getInt(3);
				String name=rs.getString(4);
				int retailPrice=rs.getInt(5);
				String itemImgRoot=rs.getString(6);
				String detailImg=rs.getString(7);
				String categoryList=rs.getString(8);
				String supplier=rs.getString(9);
				ItemDTO dto=new ItemDTO(code, price, inventory, name, retailPrice, itemImgRoot, detailImg,categoryList, supplier);
				return dto;
			}else{
				return null;
			}
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}finally{
			jdbcUtil.close(rs,pst,con);
		}
	}

}
