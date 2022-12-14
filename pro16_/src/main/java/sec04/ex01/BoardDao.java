package sec04.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDao {
	
	private DataSource dataSource;
	
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> list(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String query = "select * from board_t";
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
						.writeDate(rs.getDate("writeDate"))
						.build();
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
