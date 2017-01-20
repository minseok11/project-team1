package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.StatisticDTO;
import jdbc.util.jdbcUtil;

public class StatisticDao{
	public ArrayList<StatisticDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from statistic";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<StatisticDTO> list=new ArrayList<>();
			while(rs.next()){
				StatisticDTO dto=new StatisticDTO(
						rs.getInt("year_month"),
						rs.getInt("totalRetailPrice"),
						rs.getInt("totalSales"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<StatisticDTO> year_list(int year){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from statistic where year_month=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, year);
			rs=pst.executeQuery();
			ArrayList<StatisticDTO> list=new ArrayList<>();
			while(rs.next()){
				StatisticDTO dto=new StatisticDTO(
						rs.getInt("year_month"),
						rs.getInt("totalRetailPrice"),
						rs.getInt("totalSales"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public int update(int num){
		Connection con=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		ResultSet rs=null;
		int retailprice=0;
		int itemcost=0;
		try{
			con=jdbcUtil.getConn();
			String sql2="select * from payment where paymentnum=?";
			pst2=con.prepareStatement(sql2);
			pst2.setInt(1, num);
			rs=pst2.executeQuery();
			
			if(rs.next()){
				retailprice=rs.getInt("retailprice");
				itemcost=rs.getInt("itemcost");
			}
			String sql="update statistic set totalretailprice=totalretailprice-? , totalsales=totalsales-? where year_month=to_char(sysdate,'YYMM') ";
			pst=con.prepareStatement(sql);
			pst.setInt(1, retailprice);
			pst.setInt(2, itemcost);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
}
