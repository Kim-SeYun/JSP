package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import model.MemberVO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private MemberDao dao;
	
	@Override
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		MemberDao dao = (MemberDao) ctx.getAttribute("memberDao");
		this.dao = dao;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("user_id"));
		vo.setPwd(request.getParameter("user_pw"));
		
		boolean result = dao.isExisted(vo); // 로그인 결과
		
		if(result) {
			// 세션 객체에 아이디 데이터 바인딩
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("loginId", vo.getId());
			response.sendRedirect("/member_pro01/member/memberList");
			
		} else {
			// 다시 로그인 요청
			request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않음");
			request.getRequestDispatcher("/mem/login.jsp").forward(request, response);
		}
	
	}
	

}
