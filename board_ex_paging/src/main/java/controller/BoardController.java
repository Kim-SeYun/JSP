package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import domain.BoardVO;
import domain.Criteria;
import domain.Pagination;


@WebServlet("/board/list")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardDao dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new BoardDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Criteria criteria = new Criteria();
		
		String paramPageNum = request.getParameter("pageNum"); // 페이지 번호
		if(paramPageNum != null) {
			criteria.setPageNum(Integer.parseInt(paramPageNum));
		}
		
		List<BoardVO> list = dao.list(criteria); // 게시물 목록
		int totalCount = dao.getTotalCount(); // 게시물 수
		Pagination pagination = new Pagination(criteria, totalCount); // 페이지네이션
		request.setAttribute("list", list);
		request.setAttribute("p", pagination);
		
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
		
	}

	

}
