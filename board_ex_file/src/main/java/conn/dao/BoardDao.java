package conn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import conn.common.ConnectionUtil;
import conn.domain.BoardVO;

public class BoardDao {
	
	private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtil.getDataSource();
	}

	// 글목록
	public List<BoardVO> selectAll() {
		String query = "select * from board_tbl order by bno desc";
		List<BoardVO> list = new ArrayList();
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
				.writedate(rs.getDate("writedate"))
				.imageFileName(rs.getNString("imageFileName"))
				.replyCount(rs.getInt("replyCount"))
				.build();
			list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 글쓰기
	public int insertBoard(BoardVO vo) {
		String query = "insert into board_tbl(bno, title, content, writer, imageFileName) VALUES(?,?,?,?,?)";
		int boardNo = getNewBno();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5, vo.getImageFileName());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardNo;
	}
	
	// 새로운 글번호 생성
	public int getNewBno(){
		int boardNo = 0;
		String query = "select max(bno)+1 as boardNo from board_tbl";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			if(rs.next()) {
				boardNo = rs.getInt("boardNo");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardNo;
	}
	
	// 글상세
	public BoardVO selectOne(int bno) {
		BoardVO vo = null;
		String query = "select * from board_tbl where bno=?";
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
				
		){
			pstmt.setInt(1, bno);
			try (ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					vo = BoardVO.builder()
							.bno(rs.getInt("bno"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.writer(rs.getString("writer"))
							.writedate(rs.getDate("writedate"))
							.imageFileName(rs.getString("imageFileName"))
							.build();
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 글수정
	public void updateBoard(BoardVO vo) {
		
		String imageFileName = vo.getImageFileName();
		int bno = vo.getBno();
		String query = "update board_tbl set title=?, content=?";
		
		if(imageFileName!=null) { // 이미지 파일이 있을 때
			query += ", imageFileName=? where bno=?";
		} else { // 이미지 파일이 없을 때
			query += " where bno=?";
		}
		
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			if(imageFileName!=null) { // 이미지 파일이 있을 때
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, bno);
			} else { // 이미지 파일이 없을 때
				pstmt.setInt(3, bno);
			}
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제 처리
	public void deletBoard(int bno) {
		String query = "delete from board_tbl where bno=?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		) {
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
