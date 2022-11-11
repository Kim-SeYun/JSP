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


//@WebServlet("/sess5")
public class SessionTest5 extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); // 세션 생성
		session.setAttribute("name", "aaa");
		String encodeURL = response.encodeURL("login");
		out.print(encodeURL + "<br>");
		String name = (String) session.getAttribute("name");
		out.print("세션객체에 바인딩 된 데이터 : " + name);
	}

}
