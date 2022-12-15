package conn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conn.dao.MemberDao;
import conn.domain.AuthVO;
import conn.domain.MemberVO;
import conn.service.MemberService;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	
	private MemberService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new MemberService(new MemberDao());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String contextPath = request.getContextPath();
		final String PRIFIX = "/WEB-INF/views/member/";
		final String SUFFIX = ".jsp";
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 회원가입 폼
		if(pathInfo.equals("/joinForm")) {
			nextPage = "joinForm";
		}
		
		// 회원가입 처리
		else if(pathInfo.equals("/join")) {
			String id = request.getParameter("id");
			String pwd = (String) request.getAttribute("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO vo = MemberVO.builder()
					.id(id)
					.pwd(pwd)
					.name(name)
					.email(email)
					.build();
			service.memberJoin(vo);
			response.sendRedirect(contextPath+"/board");
			return;
		}
		
		// 로그인 폼
		else if(pathInfo.equals("/loginForm")) {
			nextPage = "loginForm";
		}
		
		// 로그인 처리
		else if(pathInfo.equals("/login")) {
			String id = request.getParameter("id");
			String pwd = (String) request.getAttribute("pwd");
			MemberVO vo = MemberVO.builder()
					.id(id).pwd(pwd).build();
			if(service.loginService(vo)) {
				HttpSession session = request.getSession();
				AuthVO authVO = new AuthVO();
				authVO.setId(vo.getId());
				session.setAttribute("auth", authVO);
				response.sendRedirect(contextPath+"/board");
				return;
			}else {
				System.out.println("MemberController.login : 아이디 또는 비밀번호 불일치");
			}
		}
		
		// 로그아웃 처리
		else if(pathInfo.equals("/logout")) {
			HttpSession session = request.getSession(false);
			session.removeAttribute("auth");
			response.sendRedirect(contextPath+"/board");
			return;
		}
		
		else {
			System.out.println("페이지를 찾을 수 없음");
			return;
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
	}

}