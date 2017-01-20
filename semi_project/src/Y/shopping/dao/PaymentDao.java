package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.DeliveryDTO;
import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.PaymentDTO;
import Y.shopping.dto.PaymentResultDTO;
import Y.shopping.dto.StatisticDTO;
import jdbc.util.jdbcUtil;

public class PaymentDao {
	public int d_insert(DeliveryDTO dto2){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		ResultSet rs=null;
		int n=0;
		try{
			con=jdbcUtil.getConn();
			String sql2="insert into delivery values(SEQ_DELIVERY_DELIVERYNO.nextval,?,?,?,?,?,?)";
			String sql="select NVL(MAX(deliveryNo),0) maxnum from delivery";
			pst2=con.prepareStatement(sql2);
			pst2.setString(1, dto2.getName());
			pst2.setString(2, dto2.getPhoneNo());
			pst2.setString(3, dto2.getPostNo());
			pst2.setString(4, dto2.getDeliveryLoc());
			pst2.setString(5, "주문완료");
			pst2.setString(6, dto2.getId());
			pst2.executeUpdate();
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				n=rs.getInt("maxnum");
				return n;
			}
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int s_insert(){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into statistic values(to_char(sysdate,'YYMM'),0,0)";
			pst=con.prepareStatement(sql);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int insert(PaymentDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		PreparedStatement pst3=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into payment values(SEQ_PAYMENT_PAYMENTNUM.nextval,?,?,?,?,?,?,?,to_char(sysdate,'YYMM'),?)";
			String sql2="update statistic set totalretailprice=totalretailprice+? , totalsales=totalsales+? where year_month=to_char(sysdate,'YYMM')";
			String sql3="update item set inventory=inventory-? where code=? ";
			pst=con.prepareStatement(sql);
			pst2=con.prepareStatement(sql2);
			pst3=con.prepareStatement(sql3);
			pst.setInt(1, dto.getItemCost());
			pst.setInt(2, dto.getRetailPrice());
			pst.setString(3, "결제완료");
			pst.setString(4, dto.getCoupon());
			pst.setString(5, dto.getId());
			pst.setString(6, dto.getCode());
			pst.setInt(7, dto.getDeliveryNo());
			pst.setInt(8, dto.getCnt());
			int n=pst.executeUpdate();
			pst2.setInt(1, dto.getRetailPrice());
			pst2.setInt(2, dto.getItemCost());
			int n2=pst2.executeUpdate();
			pst3.setInt(1, dto.getCnt());
			pst3.setString(2, dto.getCode());
			return n+n2;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public ArrayList<PaymentDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from payment";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<PaymentDTO> list=new ArrayList<>();
			while(rs.next()){
				PaymentDTO dto=new PaymentDTO(rs.getInt("paymentNum"),
						rs.getInt("itemCost"),
						rs.getInt("retailPrice"),
						rs.getString("condition"),
						rs.getString("coupon"),
						rs.getString("id"),
						rs.getString("code"),
						rs.getInt("deliveryNo"),
						rs.getInt("year_month"),
						rs.getInt("cnt")
						);
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public int getCount(String id){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select NVL(count(rnum),0) countnum from (select bb.*,rownum rnum from(select aa.*,deliverycondi from (select p.deliveryNo,p.paymentnum,i.code,i.itemimgroot,i.name,i.price,p.cnt,p.coupon,p.itemcost from item i,payment p where i.code=p.code and id=? order by p.paymentnum)aa ,delivery d where aa.deliveryNo=d.deliveryNo order by paymentnum desc)bb)cc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
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
	public ArrayList<PaymentDTO> paylist(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from payment where id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			ArrayList<PaymentDTO> list=new ArrayList<>();
			if(rs.next()){
				PaymentDTO dto=new PaymentDTO(rs.getInt("paymentNum"),
						rs.getInt("itemCost"),
						rs.getInt("retailPrice"),
						rs.getString("condition"),
						rs.getString("coupon"),
						rs.getString("id"),
						rs.getString("code"),
						rs.getInt("deliveryNo"),
						rs.getInt("year_month"),
						rs.getInt("cnt"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<PaymentResultDTO> paymentlist(String id, int startRow, int endRow){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from (select bb.*,rownum rnum from(select aa.*,deliverycondi from (select p.deliveryNo,p.paymentnum,i.code,i.itemimgroot,i.name,i.price,p.cnt,p.coupon,p.itemcost from item i,payment p where i.code=p.code and id=? order by p.paymentnum)aa ,delivery d where aa.deliveryNo=d.deliveryNo order by paymentnum desc)bb)where rnum>=? and rnum<=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			rs=pst.executeQuery();
			ArrayList<PaymentResultDTO> list=new ArrayList<>();
			while(rs.next()){
				rs.getInt(1);
				PaymentResultDTO dto=new PaymentResultDTO(
						/*
						rs.getInt("paymentnum"),
						rs.getString("code"),
						rs.getString("itemImgRoot"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getInt("cnt"),
						rs.getString("coupon"),
						rs.getInt("itemCost"),
						rs.getString("devlierycondi")
						*/
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getString(10)
						);
						
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	
	public int delete(int num){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="DELETE FROM PAYMENT WHERE PAYMENTNUM=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, num);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
}
