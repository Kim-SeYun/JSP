package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImpl;
import model.MemberVO;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	private MemberDao dao;
	
	@Override
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		MemberDao dao = (MemberDao) ctx.getAttribute("memberDao");
		this.dao = dao;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿이 어떤 기능을 수행할지 결정
		String command = request.getParameter("command");
		
		if(command!=null && command.equals("addMember")) { // 회원추가
			
		} else { // 회원조회
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher rd = request.getRequestDispatcher("/member/memberList.jsp");
			rd.forward(request, response);
		}
	}
}