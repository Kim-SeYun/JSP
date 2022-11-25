package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.domain.BoardVO;


@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	BoardDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new BoardDAO();
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
		
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) { // 글목록
			List<BoardVO> listArticles = dao.listArticles();
			request.setAttribute("list", listArticles);
			nextPage = "articleList";
			
		} else if(pathInfo.equals("/findArticle")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO detail = dao.findArticle(bno);
			request.setAttribute("article", detail);
			nextPage = "detail";
		}else if(pathInfo.equals("/writeForm")) { // 글쓰기 폼
			nextPage = "writeForm";
		}else if(pathInfo.equals("/modifyForm")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO findArticle = dao.findArticle(bno);
			request.setAttribute("article", findArticle);
			nextPage="modifyForm";
		}
		else if(pathInfo.equals("/addArticle")) { // 글쓰기 처리
			BoardVO vo = BoardVO.builder()
					.title(request.getParameter("title"))
					.content(request.getParameter("content"))
					.writer(request.getParameter("writer")).build();
			dao.addArticle(vo);
			response.sendRedirect(contextPath+"/board");
			return;
		} else if(pathInfo.equals("/delArticle")) { // 글삭제
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			dao.delArticle(bno);
			response.sendRedirect(contextPath+"/board");
			return;
		} else if(pathInfo.equals("/modArticle")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO vo = BoardVO.builder()
					.bno(bno)
					.title(request.getParameter("title"))
					.content(request.getParameter("content")).build();
			dao.modArticle(vo);
			response.sendRedirect(contextPath+"/board");
			return;
		}
		else { 
			request.getRequestDispatcher("/WEB-INF/views/error/_404.jsp").forward(request, response);
			return;
		}
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
		
	}

}
