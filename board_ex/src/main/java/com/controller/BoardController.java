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
		final String PRIFIX = "/WEB-INF/views/board/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<BoardVO> listArticles = dao.listArticles();
			request.setAttribute("list", listArticles);
			nextPage = "articleList";
			
		} else if(pathInfo.equals("/findArticle")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			BoardVO detail = dao.findArticle(bno);
			request.setAttribute("article", detail);
			nextPage = "detail";
		}
		else { 
			System.out.println("페이지 없음");
			return;
		}
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
		
	}

}
