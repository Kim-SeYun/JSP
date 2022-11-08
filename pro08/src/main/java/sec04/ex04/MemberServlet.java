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
		RequestDispatcher rd = request.getRequestDispatcher("/memberList.jsp");
		
		List<MemberVO> memberList = dao.memberList();
		request.setAttribute("list", memberList);
		rd.forward(request, response);
	}

}