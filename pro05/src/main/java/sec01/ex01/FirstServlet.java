package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("FirstServlet 초기화 : init 메소드 실행");
	}
	
	// doGet, doPost 요청받은 작업을 수행
	// 요청을 받을 때 마다 실행
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get방식의 요청에 응답
		System.out.println("doGet() 메소드 실행");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post방식의 요청에 응답
		System.out.println("doPost() 메소드 실행");
	}

}
