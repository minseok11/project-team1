package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.CouponDTO;
import Y.shopping.dto.CouponSearchDTO;
import Y.shopping.dto.CreateCouponDTO;
import Y.shopping.dto.ItemDTO;
import jdbc.util.jdbcUtil;

public class CouponDao {
	public int insert(CouponDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into coupon values(?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setInt(2, dto.getDiscount());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int c_insert(CreateCouponDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		ResultSet rs=null;
		int n=0;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from createcoupon where id=? and name=?";
			String sql2="insert into createcoupon values(SEQ_CREATECOUPON_CREATENUM.nextval,?,?,?,sysdate)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getName());
			rs=pst.executeQuery();
			if(rs.next()){
				System.out.println("이미 존재하는 쿠폰입니다.");
				return -1;
			}else{
				System.out.println(dto.getName()+"쿠폰생성");
				pst2=con.prepareStatement(sql2);
				pst2.setString(1, dto.getName());
				pst2.setString(2, dto.getId());
				pst2.setString(3, "사용가능");
				n=pst2.executeUpdate();
			}
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public CreateCouponDTO getinfo(CouponSearchDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select createnum,discount,c.name,id,used,usedate from createcoupon c,coupon cp where c.name=cp.name and id=? and discount=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setInt(2, dto.getDiscount());
			rs=pst.executeQuery();
			if(rs.next()){
				CreateCouponDTO cdto=new CreateCouponDTO(
						rs.getInt("createNum"),
						rs.getString("name"),
						rs.getString("id"),
						rs.getString("used"),
						rs.getString("usedate"));
				return cdto;
			}
			return null;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public int update(int num){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="update createcoupon set used=? where createnum=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, "사용불가");
			pst.setInt(2, num);
			int n=pst.executeUpdate();
			System.out.println("쿠폰 업데이트!!");
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<CreateCouponDTO> listAll(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from createcoupon";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<CreateCouponDTO> list=new ArrayList<>();
			while(rs.next()){
				CreateCouponDTO dto=new CreateCouponDTO(
						rs.getInt("createNum"),
						rs.getString("name"), 
						rs.getString("id"), 
						rs.getString("used"),
						rs.getString("usedate"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<CouponSearchDTO> list(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql=" select createnum,c.name,id,discount,used,usedate from createcoupon c,coupon cp where c.name=cp.name and id=? ";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			ArrayList<CouponSearchDTO> list=new ArrayList<>();
			while(rs.next()){
				CouponSearchDTO dto=new CouponSearchDTO(
						rs.getInt("createNum"),
						rs.getString("name"), 
						rs.getString("id"), 
						rs.getInt("discount"),
						rs.getString("used"),
						rs.getString("usedate"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<CouponSearchDTO> searchList(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql=" select createnum,c.name,id,discount,used,usedate from createcoupon c,coupon cp where c.name=cp.name and id=? and used=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, "사용가능");
			rs=pst.executeQuery();
			ArrayList<CouponSearchDTO> list=new ArrayList<>();
			while(rs.next()){
				CouponSearchDTO dto=new CouponSearchDTO(
						rs.getInt("createNum"),
						rs.getString("name"), 
						rs.getString("id"), 
						rs.getInt("discount"),
						rs.getString("used"),
						rs.getString("usedate"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
}
