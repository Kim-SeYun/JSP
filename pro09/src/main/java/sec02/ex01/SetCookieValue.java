package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		
		// 쿠키 생성, 쿠키값 지정시 인코딩을 해야함
		Cookie c1 = new Cookie("jsp",URLEncoder.encode("JSP프로그래밍", "utf-8"));
		Cookie c2 = new Cookie("oracle",URLEncoder.encode("오라클데이터베이스", "utf-8"));
		// 쿠키 유효시간을 지정하지 않으면 세션쿠키 생성(브라우저 메모리 - 브라우저 종료시 삭제)
		// 쿠키 유효시간을 지정하면 퍼시스턴트 쿠키 생성(파일로 저장)
		c1.setMaxAge(60*60*24); // 단위 : 초
		c1.setMaxAge(-1); // 유효시간을 음수로 지정 : 세션쿠키
		
		response.addCookie(c1); // 생성된 쿠키를 브라우저로 전송
		response.addCookie(c2);

		out.print("현재시간 : " + d +"<br>");
		out.print("문자열을 Cookie에 저장");
		
	
	}

	

}
