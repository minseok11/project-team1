package shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.util.jdbcUtil;
import shopping.dto.InterestDTO;

public class InterestDao {
	public String insert(InterestDTO dto){
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=jdbcUtil.getConn();
			String sql="insert into interest values(?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1, dto.getCode());
			pst.setString(2, dto.getId());
			pst.executeUpdate();
			return "�߰�����";
		}catch(SQLException se){
			try{
				String sql1="delete interest where id=? and code=?";
				pst=con.prepareStatement(sql1);
				pst.setString(1, dto.getCode());
				pst.setString(2, dto.getId());
				pst.executeUpdate();
				return "��Ҽ���"; 
			}catch(SQLException s){
				System.out.println(s.getMessage());
				return "�����߻�";
			}
		}finally{
			jdbcUtil.close(null, pst, con);
		}
	}
	
}
