package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("TestServlet1 : 서블릿 매핑 <br>");
		
		String contextPath = request.getContextPath(); // pro10
		String uri = request.getRequestURI();
		String mapping = request.getServletPath();
		String url = request.getRequestURL().toString();
		
		out.print("컨텍스트 패스 : " + contextPath + "<br>");
		out.print("URL : " + url + "<br>");
		out.print("URI : " + uri + "<br>");
		out.print("서블릿 매핑 : " + mapping + "<br>");
	}

	

}
