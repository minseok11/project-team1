package Y.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Y.shopping.dto.ItemDTO;
import Y.shopping.dto.ReturnDTO;
import Y.shopping.dto.ReturnItemDTO;
import jdbc.util.jdbcUtil;

public class ReturnItemDao {
	public ArrayList<ReturnDTO> search(String option,String search){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			System.out.println(option);
			System.out.println(search);
			String sql=" SELECT RETURNNO,CODE,ID,REASON,RETURNCONDI,P.PAYMENTNUM "+
						" FROM RETURNITEM R,PAYMENT P " +
						" WHERE "+option+" LIKE '%"+search+"%' " +
						" AND R.PAYMENTNUM=P.PAYMENTNUM(+) ";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<ReturnDTO> list=new ArrayList<>();
			while(rs.next()){
				ReturnDTO dto=new ReturnDTO(rs.getInt("returnNo"),
						rs.getString("code"),
						rs.getString("id"),
						rs.getString("reason"),
						rs.getString("returnCondi"),
						rs.getInt("paymentNum"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<ReturnDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql=" SELECT RETURNNO,CODE,ID,REASON,RETURNCONDI,P.PAYMENTNUM "+
						" FROM RETURNITEM R,PAYMENT P "+
						" WHERE R.PAYMENTNUM=P.PAYMENTNUM(+)";
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			ArrayList<ReturnDTO> list=new ArrayList<>();
			while(rs.next()){
				ReturnDTO dto=new ReturnDTO(rs.getInt("returnNo"),
						rs.getString("code"),
						rs.getString("id"),
						rs.getString("reason"),
						rs.getString("returnCondi"),
						rs.getInt("paymentNum"));
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public int delete(int returnNo){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="DELETE FROM RETURNITEM WHERE RETURNNO=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, returnNo);
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
	public int insert(ReturnItemDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into returnitem values(SEQ_RETURNITEM_RETURNNO.nextval,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getReason());
			pst.setString(2, dto.getReturnCondi());
			pst.setInt(3, dto.getPaymentNum());
			int n=pst.executeUpdate();
			return n;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return -1;
		}
	}
}





