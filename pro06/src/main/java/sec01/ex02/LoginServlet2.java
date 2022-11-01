package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testId = "admin";
		String testPw = "1234";
		String id = req.getParameter("user_id").trim();
		String pw = req.getParameter("user_pw").trim();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("");
		out.print("<html>");
		out.print("<body>");
		if(id !=null && pw != null && id.equals(testId) && pw.equals(testPw)) {
			// 로그인에 성공한 경우
			out.print("<p>");
			out.print("관리자("+id+")님 반갑습니다.");
			out.print("</p>");
		}else {
			// 로그인에 실패한 경우
			out.print("<p>");
			out.print("아이디 또는 비밀번호가 일치하지 않습니다.");
			out.print("</p>");
			out.print("<a href='/pro06/login2.html'>로그인 페이지로 가기</a>");
		}
		
		out.print("</body>");
		out.print("</html>");
	
	}

}
