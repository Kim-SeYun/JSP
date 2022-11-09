package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(
//		urlPatterns = { 
//				"/sinit", 
//				"/sinit2"
//		}, 
//		initParams = { 
//				@WebInitParam(name = "email", value = "admin@example.com"), 
//				@WebInitParam(name = "tel", value = "010-1111-2222")
//		})
public class InitParamServlet extends HttpServlet {
	
	public InitParamServlet() {
		System.out.println("InitParamServlet 객체생성");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet : init 메서드 호출");
	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td> 이메일 : </td><td>" + email + "</td></tr>");
		out.print("<tr><td>휴대전화 : </td><td>" + tel + "</td>");
		out.print("</tr></table></body></html>");
	}

}
