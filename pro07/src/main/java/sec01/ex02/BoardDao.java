package sec01.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sec01.ex03.MemberVO;


public class BoardDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "scott";
	private static final String PWD = "tiger";
	private Connection con; // 오라클에 연동하는데 필요한 객체
	private PreparedStatement pstmt; // 데이터베이스에 쿼리문 전달
	
	List<BoardVO> listBoards() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		connDB();
		String query = "SELECT * FROM BOARD_TBL";
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			int i=0;
			while(rs.next()) {
				// @param : 테이블 걸럼
				BoardVO vo = new BoardVO(
					rs.getInt("BNO"),
					rs.getString("TITLE"),
					rs.getString("CONTENT"),
					rs.getString("WRITER"),
					rs.getDate("REGDATE"),
					rs.getDate("UPDATEDATE")); 
				list.add(vo); // 리스트에 추가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addBoard(BoardVO vo) {
		connDB();
		int bno = vo.getBno();
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		String query = "INSERT INTO BOARD_TBL(BNO, TITLE, CONTENT, WRITER) VALUES(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, writer);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void connDB() {
		try {
			Class.forName(DRIVER); // OracleDriver객체 생성
			// 커넥션 객체를 얻음
			con = DriverManager.getConnection(URL,USER,PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}

