package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		String email = request.getParameter("user_email");
		String hp = request.getParameter("user_hp");
		
		StringBuffer sb = new StringBuffer();
		sb.append("아이디 : " + id);
		sb.append("비밀번호 : " + pw);
		sb.append("주소 : " + address);
		sb.append("이메일 : " + email);
		sb.append("휴대전화 : " + hp);
		out.print(sb);
	
	}

}
