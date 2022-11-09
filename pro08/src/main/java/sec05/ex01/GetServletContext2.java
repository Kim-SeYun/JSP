package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget2")
public class GetServletContext2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿 컨텍스트 얻기
		ServletContext ctx = getServletContext();
		List<String> memberList = (List<String>) ctx.getAttribute("members");
		String member1 = memberList.get(0);
		String member2 = memberList.get(1);
		out.print("cget2<br>");
		out.print(member1+"<br>");
		out.print(member2+"<br>");
	
	}

}
