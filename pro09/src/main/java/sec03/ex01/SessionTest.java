package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sess")
public class SessionTest extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); // 세션 생성
		out.print("세션 아이디 : " + session.getId()+ "<br>");
		out.print("최초 세션 생성 시각 : " + new Date(session.getCreationTime())+ "<br>");
		out.print("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime())+ "<br>");
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval()+ "<br>");
		if(session.isNew()) {
			out.print("세션 생성");
		}
	
	}

}
