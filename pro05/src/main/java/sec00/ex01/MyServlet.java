package sec00.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
	
	public MyServlet() {
		System.out.println("MyServlet : 서블릿 생성");
	}
	
	@Override
	public void init() throws ServletException {
		// 최초 요청시 초기화 작업 수행
		System.out.println("초기화작업수행");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get방식 요청시 실행
		
	
	}

}
