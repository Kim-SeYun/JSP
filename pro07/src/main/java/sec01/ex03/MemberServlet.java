package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/members")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		MemberDao dao = new MemberDao();
		
		if(command!=null && command.equals("memberjoin")) { // 회원가입
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			dao.addMember(new MemberVO(id, pwd, name, email));
			response.sendRedirect("/pro07"); // 지정된 페이지로 이동
			// 아래 코드는 실행되지 않음
		} else if(command!=null && command.equals("delMember")) {
			String id = request.getParameter("id");
			if(id!=null) dao.delMember(id);
			response.sendRedirect("/pro07");
		} else {
			List<MemberVO> listMembers = dao.listMembers();
			out.print("");
			out.print("<table border=1><tr>");
			out.print("<th>아이디</th>");
			out.print("<th>비밀번호</th>");
			out.print("<th>이름</th>");
			out.print("<th>이메일</th>");
			out.print("<th>가입일</th>");
			out.print("<th>삭제</th></tr>");
			
			
			// 반복구간
			for(MemberVO vo : listMembers) {
				out.print("<tr><td>" +vo.getuId()+ "</td>");
				out.print("<td>" +vo.getPwd()+ "</td><td>" +vo.getuName()+ "</td>");
				out.print("<td>" +vo.getEmail()+ "</td>");
				out.print("<td>" +vo.getDate()+ "</td>");
				out.print("<td><a href='/pro07/members?command=delMember&id="+vo.getuId()+"'>삭제</a></td></tr>");
			}
			out.print("</table>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}