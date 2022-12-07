package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDao;
import com.domain.BoardVO;
import com.service.BoardService;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	
	private BoardService service;
	
	@Override
	public void init() throws ServletException {
		BoardDao dao = new BoardDao();
		service = new BoardService(dao);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PRIFIX = "/WEB-INF/views/board/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 글목록
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<BoardVO> boardList = service.boardList();
			request.setAttribute("list", boardList);
			nextPage = "list";
		}
		
		// 글상세
		else if(pathInfo.equals("/detail")) {
			String parambno = request.getParameter("bno");
			int bno = Integer.parseInt(parambno);
			BoardVO board = service.findBoard(bno);
			request.setAttribute("board", board);
			nextPage = "detail";
		}
		else {
			System.out.println("존재하지 않는 페이지");
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
	}

}
