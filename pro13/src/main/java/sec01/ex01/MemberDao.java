package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	private DataSource dataSource;
	
	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<MemberBean> listMembers(){
		List<MemberBean> list = new ArrayList<MemberBean>();
		String query = "select * from t_member order by joinDate desc";
		try (
			Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				MemberBean bean = new MemberBean();
				bean.setMno(rs.getInt("mno"));
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setJoinDate(rs.getDate("joinDate"));
				list.add(bean);
			}
			
		} catch (Exception e) {
			
		}
		
		return list;
	}
}
