package Hwang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import Hwang.dto.BIDTO;
import Hwang.dto.BasketDto;
import shopping.dto.BuyDTO;


public class BasketDao {
	
	public ArrayList<BIDTO> IdList(String id){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select b.buynum,totalprice,name,b.code,itemimgroot,cnt from buy b,item i where b.code=i.code and id=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, id);
			ArrayList<BIDTO> list=new ArrayList<>();
			rs=pst.executeQuery();
			while(rs.next()){
				BIDTO dto=new BIDTO(
						rs.getInt("buynum"),
						rs.getInt("totalprice"),
						rs.getString("name"),
						rs.getString("code"),
						rs.getString("itemimgroot"),
						rs.getInt("cnt")
					);
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

	public int insert(BasketDto dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into buy values(SEQ_BUY_BUYNUM.nextval,?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setInt(1, dto.getTotalPrice());
			pst.setString(2, dto.getId());
			pst.setString(3, dto.getCode());
			pst.setInt(4, dto.getCnt());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
	public int delete(int buyNum){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="delete from buy where buyNum=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, buyNum);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
}
