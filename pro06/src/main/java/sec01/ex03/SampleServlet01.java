package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sample01")
public class SampleServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		System.out.println("SampleServlet doGet");
   		String id = request.getParameter("memberId");
   		String email = request.getParameter("memberEmail");
   		String etc = request.getParameter("etc");
   		String memberPw = request.getParameter("memberPw");
   		
   		System.out.println("아이디 : " + id);
   		System.out.println("이메일 : " + email);
   		System.out.println("기타사항 : " + etc);
   		
   		
   		response.setContentType("text/html;charset=utf-8");
   		PrintWriter out = response.getWriter();
   		out.print("<div>아이디 : "+id+" </div>");
   		out.print("<div>비밀번호 : "+memberPw+" </div>");
   		out.print("<div>이메일 : "+email+" </div>");
   		out.print("<div>기타사항 : "+etc+" </div>");
   	
   	}

	

}
