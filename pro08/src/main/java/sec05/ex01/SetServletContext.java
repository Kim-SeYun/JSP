package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cset")
public class SetServletContext extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿 컨텍스트 얻기 : 톰캣이 실행괼 때 하나만 생성
		ServletContext ctx = getServletContext();
		List<String> list = new ArrayList<String>();
		list.add("이순신");
		list.add("류성룡");
		
		// 서블릿 컨텍스트에 데이터 바인됨
		// 애플리케이션 어디서나 getAttribute를 통하여 참조할 수 있음
		ctx.setAttribute("members", list);
		
		out.print("<h1>서블릿 컨텍스트 데이터 바인딩</h1>");
		out.print("이순신, 류성룡 ...");
		
		
	
	}

	
	

}
