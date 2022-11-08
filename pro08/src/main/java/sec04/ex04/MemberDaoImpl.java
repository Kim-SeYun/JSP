package sec04.ex04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoImpl implements MemberDao {
	
	private DataSource datasource;
	
	public MemberDaoImpl() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:/comp/env");
			datasource = (DataSource) env.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement("select * from t_member");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getInt("mno"), 
						rs.getString("id"), 
						rs.getString("name"), 
						rs.getString("pwd"), 
						rs.getString("email")
				);
				vo.setJoinDate(rs.getDate("joinDate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public void addMember(MemberVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into t_member(mno,id,pwd,name, email) ";
		query += "values(mno_seq.nextval,?,?,?,?)";
				
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}