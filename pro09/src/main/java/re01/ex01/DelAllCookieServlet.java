package re01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLDecoder;
import java.net.URLEncoder;


@WebServlet("/delAllCookie")
public class DelAllCookieServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키 이름이 java인 쿠키 삭제
//		Cookie java = new Cookie("java", null);
//		java.setMaxAge(0);
//		response.addCookie(java);
		
		Cookie[] ck = request.getCookies(); // 모든 쿠키 가져옴
		if(ck!=null) { // 생성된 쿠키가 있으면
			for(Cookie c : ck) { // 모든 쿠키를 반복
				c.setMaxAge(0); // 모든 쿠키 삭제
				response.addCookie(c); 
			}
		}
	}

	

}
