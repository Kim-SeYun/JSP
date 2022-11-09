package sec05.exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sample/second")
public class SecondServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 리퀘스트에 바인딩된 데이터 얻기
		String name = (String) request.getAttribute("name");
		
		// 서블릿 컨텍스트에 바인딩된 데이터 언기
		ServletContext ctx = getServletContext();
		String subject = (String) ctx.getAttribute("subject");
		
		out.print("서블릿 리퀘스트 객체 데이터 : " + name + "<br>");
		out.print("서블릿 컨텍스트 데이터 : " + subject + "<br>");
	}
	
		
	
	


}
