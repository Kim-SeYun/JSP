package sec02.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
	private DataSource dataSource;
	
	public MemberDao() {
		
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean overlapedId(String id) {
		boolean result = false;
		String query = "select decode(count(*), 1,'true', 'false') as result from t_member where id=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) result = Boolean.parseBoolean(rs.getString("result"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
