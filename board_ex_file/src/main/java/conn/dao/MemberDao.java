package conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import conn.common.ConnectionUtil;
import conn.domain.BoardVO;
import conn.domain.MemberVO;

public class MemberDao {
	
private DataSource dataSource;
	
	public MemberDao() {
		dataSource = ConnectionUtil.getDataSource();
	}
	
	// 회원가입
	public void insertMember(MemberVO vo) {
		String query = "insert into t_member(mno, id, pwd, name, email) VALUES(MNO_SEQ.NEXTVAL,?,?,?,?)";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 로그인 체크
	public boolean loginCheck(MemberVO vo) {
		boolean result = false;
		String query = "select decode(count(*),1,'TRUE','FALSE') as result from t_member where id=? and pwd=?";
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					result = Boolean.parseBoolean(rs.getString("result"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
