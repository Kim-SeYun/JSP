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


@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] ck = request.getCookies(); // 모든 쿠키 가져옴
		if(ck!=null) { // 생성된 쿠키가 있으면
			for(Cookie c : ck) { // 모든 쿠키를 반복
				if(c.getName().equals("java")) { // 쿠키 이름이 java이면
					out.print(URLDecoder.decode(c.getValue(), "utf-8")); // 쿠키 값 출력
				}
			}
		}
	}

	

}
