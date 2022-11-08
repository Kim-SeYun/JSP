package sec04.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/member/ex04/views")
public class MemberViews extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		List<MemberVO> memberList = (List<MemberVO>) req.getAttribute("list");
		
		
		out.print("<table border=\"1\"><tr>");
		out.print("<th>회원번호</th><th>아이디</th>");
		out.print("<th>이름</th><th>패스워드</th>");
		out.print("<th>이메일</th><th>가입일</th></tr>");
		
		// 반복구간
		for(MemberVO vo : memberList) {
			int mno = vo.getMno();
			String id = vo.getId();
			String name = vo.getName();
			String password = vo.getPassword();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			
		
		out.print("<tr><td>"+mno+"</td>");
		out.print("<td>"+id+"</td><td>"+name+"</td>");
		out.print("<td>"+password+"</td><td>"+email+"</td>");
		out.print("<td>"+joinDate+"</td></tr>");
		
		}
		out.print("</table>");
	}
}
