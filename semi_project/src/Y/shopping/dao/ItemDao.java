package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Y.shopping.dto.CategoryDTO;
import Y.shopping.dto.ItemDTO;
import jdbc.util.jdbcUtil;

public class ItemDao {
	public int getMaxNum(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			// select max(num) from...하면 되지만 만약 null값일 경우(글이 하나도 없을때) 오류가 나기 때문에 NVL을 사용해서 0으로 만든다.
			// NVL(이곳이 null일때,이걸로 해라)
			String sql="select NVL(MAX(code),0) maxnum from item";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			// int num=rs.getInt(1);
			int num=rs.getInt("maxnum");
			return num;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(rs, pstmt, con);
		}
	}
	// 전체 글의 갯수 구하기
	public int getCount(String select, String data){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select NVL(count(code),0) countnum from item where "+select+" like ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+data+"%");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt("countnum");
			return num;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(rs, pstmt, con);
		}
	}
	public ArrayList getName(String code){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select itemimgroot,detailimg from item where code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
			rs=pst.executeQuery();
			ArrayList list=new ArrayList<>();
			if(rs.next()){
				ItemDTO dto=new ItemDTO();
				dto.setItemImgRoot(rs.getString("itemImgRoot"));
				dto.setDetailImg(rs.getString("detailImg"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
				
		
	}
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
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int update(ItemDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="update item set price=? , "
					+ " inventory=? , name=? , retailprice=? , itemimgroot=? , detailImg=? , categorylist=? , supplier=? "
					+ " where code=? ";
			pst=con.prepareStatement(sql);
			pst.setInt(1, dto.getPrice());
			pst.setInt(2, dto.getInventory());
			pst.setString(3, dto.getName());
			pst.setInt(4, dto.getRetailPrice());
			pst.setString(5, dto.getItemImgRoot());
			pst.setString(6, dto.getDetailImg());
			pst.setString(7, dto.getCategoryList());
			pst.setString(8, dto.getSupplier());
			pst.setString(9, dto.getCode());
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
	public ArrayList<ItemDTO> search(int startRow, int endRow,String option,String search){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from(select * from(select aa.*,rownum \"RNUM\" from(select * from item where "+option+" LIKE '%"+search+"%')aa) order by rnum desc)where rnum<=? and rnum>=? ";
			pst=con.prepareStatement(sql);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
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
	public ArrayList<ItemDTO> list(int startRow, int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from(select * from(select aa.*,rownum \"RNUM\" from(select * from item)aa) order by rnum desc)where rnum<=? and rnum>=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
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
	public ArrayList<ItemDTO> detail(String code){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from item where code=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, code);
			rs=pst.executeQuery();
			ArrayList<ItemDTO> list=new ArrayList<>();
			if(rs.next()){
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
}
