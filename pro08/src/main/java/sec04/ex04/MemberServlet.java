package sec04.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/ex04")
public class MemberServlet extends HttpServlet {
	/*
		MemberDao -> MemberServlet -> MemberViews
	*/
	private MemberDao dao;
	
	public MemberServlet() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		if(command!=null && command.equals("addMember")) { // 회원가입			
			MemberVO vo = new MemberVO(
					request.getParameter("id"),
					request.getParameter("pwd"),
					request.getParameter("name"),
					request.getParameter("email"));
			dao.addMember(vo);
			response.sendRedirect("/pro08/index.html");
		} else if(command!=null && command.equals("delMember")) {
			System.out.println("회원삭제");
			String inputMno = request.getParameter("mno");
			int mno = Integer.parseInt(inputMno);
			dao.delMember(mno);
			response.sendRedirect("/pro08/index.html");
			
			
		}
		
		else { // 회원목록
			RequestDispatcher rd = request.getRequestDispatcher("/memberList.jsp");
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("list", memberList);
			rd.forward(request, response);
		}
		
	}

}