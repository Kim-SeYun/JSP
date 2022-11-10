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


@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie c1 = new Cookie("java", URLEncoder.encode("자바 프로그래밍", "utf-8"));
		Cookie c2 = new Cookie("Spring", URLEncoder.encode("스프링 프로그래밍", "utf-8"));
		Cookie c3 = new Cookie("Oracle", URLEncoder.encode("오라클 프로그래밍", "utf-8"));
		
		// 퍼시스턴스(영속화) 쿠키
		c1.setMaxAge(60*60*24); // 시간의 단위 : 초
		c2.setMaxAge(60*60);
		c3.setMaxAge(60*60);
		
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		System.out.println("쿠키생성");
		
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
