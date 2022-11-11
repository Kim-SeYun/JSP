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
			session.setAttribute("login.id", vo.getId());
			response.sendRedirect("/member_pro01/member");
			
		} else {
			// 다시 로그인 요청
			response.sendRedirect("/member_pro01/member/login.html");
		}
	
	}
	

}
