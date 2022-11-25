package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.domain.BoardVO;

public class BoardDAO {

	private DataSource dataSource;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
			System.out.println(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> listArticles() {
		List<BoardVO> list = new ArrayList<>();
		String query = "SELECT * FROM board_t ORDER BY bno DESC";
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				BoardVO vo = BoardVO.builder()
						.bno(rs.getInt("bno"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.writer(rs.getString("writer"))
						.writeDate(rs.getDate("writeDate")).build();
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 회원 가입
	public void addArticle(BoardVO vo) {
		String query = "insert into board_t(bno, title, content,writer) values(bno_seq.nextval,?,?,?)";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원상세정보
	public BoardVO findArticle(int bno) {
		BoardVO vo = null;
		String query = "SELECT * FROM board_t WHERE bno=?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, bno);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
						vo = BoardVO.builder()
								.bno(rs.getInt("bno"))
								.title(rs.getString("title"))
								.content(rs.getString("content"))
								.writer(rs.getString("writer"))
								.writeDate(rs.getDate("writeDate")).build();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 회원수정
	public void modArticle(BoardVO vo) {
		String query = "UPDATE board_t SET title=?, content=? WHERE bno=?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	// 회원삭제
		public void delArticle(int bno) {
			String query = "DELETE FROM board_t WHERE bno=?";
			try(
				Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
			){
				pstmt.setInt(1, bno);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}