package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		// POST방식으로 요청할 때에는 반드시 인코딩 설정을 해야함
		request.setCharacterEncoding("utf-8"); // 한글 인코딩
		response.setContentType("text/html;charset=utf-8"); // 마임타입지정
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		StringBuffer sb = new StringBuffer();
		sb.append("아이디 : " +id+ "<br>");
		sb.append("비밀번호 : " +pw);
		out.print(sb);
	}

}