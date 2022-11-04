package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDao dao = new MemberDao();
		List<MemberVO> listMembers = dao.listMembers();
		
		out.print("<table border = 1> <tr>");
		out.print("<th>아이디</th>");
		out.print("<th>비밀번호</th>");
		out.print("<th>이름</th>");
		out.print("<th>이메일</th>");
		out.print("<th>가입일</th></tr>");
		
		// 반복구간
		for(MemberVO vo : listMembers) {
			
			out.print("<tr><td>"+vo.getuId()+"</td>");
			out.print("<td>"+vo.getPwd()+"</td><td>"+vo.getuName()+"</td>");
			out.print("<td>"+vo.getEmail()+"</td>");
			out.print("<td>"+vo.getDate()+"</td></tr>");
			
		}
	}

	
}
