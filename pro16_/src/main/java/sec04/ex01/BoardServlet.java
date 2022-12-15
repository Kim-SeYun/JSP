package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;import javax.print.attribute.HashPrintJobAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;


@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	
	private BoardDao dao;
	
	@Override
	public void init() throws ServletException {
		dao = new BoardDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String pathInfo = request.getPathInfo();
		if(pathInfo.equals("/list")) {
			List<BoardVO> list = dao.list();
			String boardList = new Gson().toJson(list);
			out.print(boardList);
			
		} else if(pathInfo.equals("/detail")) {
			String paramBno = request.getParameter("bno");
			BoardVO vo = dao.detail(Integer.parseInt(paramBno));
			String detail = new Gson().toJson(vo);
			out.print(detail);
		} else if(pathInfo.equals("/remove")) {
			String paramBno = request.getParameter("bno");
			int bno = Integer.parseInt(paramBno);
			dao.delete(bno);
			System.out.println(paramBno);
			String result = new Gson().toJson(paramBno+"번 게시물 삭제함");
			out.print(result);
		}
		
		else {
			throw new ServletException();
		}
		
	}

}
