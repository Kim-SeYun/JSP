package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	
	public SecondServlet() {
		System.out.println("MyServlet : 서블릿 생성");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("초기화작업수행");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet() 메소드 실행");
	}
	
	

}
