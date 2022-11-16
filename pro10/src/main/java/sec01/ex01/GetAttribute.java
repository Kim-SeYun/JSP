package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext(); // 서블릿 컨텍스트 객체
		HttpSession session = request.getSession(); // 세션 객체
		
		String ctxMsg = (String) ctx.getAttribute("context"); // 서블릿 컨텍스트와 바인딩된 데이터 가져오기
		String sesMsg = (String) session.getAttribute("session"); // 세션에 비안딩된 데이터 가져오기
		String reqMsg = (String) request.getAttribute("request"); // 리퀘스트에 바인딩된 데이터 가져오기
		
		out.print("서블릿컨텍스트 : " + ctxMsg + "<br>");
		out.print("세션 : " + sesMsg + "<br>");
		out.print("리퀘스트 : " + reqMsg + "<br>");
	}

	

}
