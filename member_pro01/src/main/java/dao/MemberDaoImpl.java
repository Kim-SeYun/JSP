package dao;

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

import model.MemberVO;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDaoImpl dao = new MemberDaoImpl();
	
	private DataSource dataSource;
	
	private MemberDaoImpl() {
		try {
			Context context = new InitialContext();
			Context env = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) env.lookup("jdbc/oracle");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDaoImpl getInstance() {
		return dao;
	}
	
	// 회원목록
	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = new ArrayList<>();
		String query = "SELECT * FROM T_MEMBER";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMno(rs.getInt("mno"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
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
		// 회원 추가
		String query = "INSERT INTO T_MEMBER(mno,id,pwd,name,email) values(MNO_SEQ.NEXTVAL,?,?,?,?)";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delMember(int mno) {
		// 회원 삭제
		String query = "delete from t_member where mno=?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean isExisted(MemberVO vo) {
		// 로그인 인증검사
		boolean result = false;
		String query = "select decode(count(*),1,'true','false') "
				+ "as result from t_member where id=? and pwd =?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			try(ResultSet rs = pstmt.executeQuery();) {
				while(rs.next()) {
					result = Boolean.parseBoolean(rs.getString("result"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}