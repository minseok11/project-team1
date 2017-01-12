package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.util.jdbcUtil;
import shopping.dto.CustomerInfoDTO;

public class CustomerInfoDao {
	public ArrayList<CustomerInfoDTO> list(){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=jdbcUtil.getConn();
			String sql="select * from users";
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
				list.add(dto);
			}
			return list;
		}catch(SQLException se){
			System.out.println(se.getMessage());
			return null;
		}
	}
	public ArrayList<CustomerInfoDTO> listUp(String id){
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
           con=jdbcUtil.getConn();
           String sql="select * from CUSTOMERINFO where id=?";
           pstmt=con.prepareStatement(sql);
           pstmt.setString(1, id);
           rs=pstmt.executeQuery();
           ArrayList<CustomerInfoDTO> list=new ArrayList<>();
           rs.next();
           String password=rs.getString(2);
           String qesList=rs.getString(3);
           String ans=rs.getString(4);
           String name=rs.getString(5);
           String gender=rs.getString(6);
           String email=rs.getString(7);
           String phoneNo=rs.getString(8);
           String adress=rs.getString(9);
           String postNo=rs.getString(10);
           CustomerInfoDTO dto=new CustomerInfoDTO(id, password, qesList, ans, name, gender, email, phoneNo, adress, postNo);
           list.add(dto);
           return list;
        }catch(SQLException se){
           System.out.println(se.getMessage());
           return null;
        }finally{
           jdbcUtil.close(rs, pstmt, con);
        }
     }
}
