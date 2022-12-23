package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import common.ConnectionUtil;
import domain.BoardVO;
import domain.Criteria;

public class BoardDao {
	
private DataSource dataSource;
	
	public BoardDao() {
		dataSource = ConnectionUtil.getDataSource();
	}

	public List<BoardVO> list(Criteria criteria) {
		String query = "select rownum, bno, title, content, writer, writedate ";
		query += "from (select /*+index_desc(board_paging pk_board)*/ rownum as rn, bno, title, content, writer, writedate ";
		query += "from board_paging ";
		query += "where rownum<=?) where rn > ?";
		List<BoardVO> list = new ArrayList<>();
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
		){
			int maxRow = criteria.getPageNum()*criteria.getAmount();
			int minRow = (criteria.getPageNum() - 1) * criteria.getAmount();
			pstmt.setInt(1, maxRow);
			pstmt.setInt(2, minRow);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					BoardVO vo = BoardVO.builder()
					.bno(rs.getInt("bno"))
					.title(rs.getString("title"))
					.content(rs.getString("content"))
					.writer(rs.getString("writer"))
					.writedate(rs.getDate("writedate"))
					.build();
				list.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getTotalCount() {
		String query = "select count(bno) as count from board_paging";
		int totalcount = 0;
		try (
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		){
			if(rs.next()) {
				totalcount = rs.getInt("count");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalcount;
	}

}
