package sec01.ex01;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {
	
	private MemberDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		final String PRIFIX = "/WEB-INF/views/member/";
		final String SUFFIX = ".jsp";
		
		
		RequestDispatcher rd = null;
		String nextPage = null;
		
		// 회원목록페이지
		if(pathInfo==null || pathInfo.equals("/") || pathInfo.equals("/list")) {
			List<MemberVO> listMembers = dao.listMembers();
			request.setAttribute("memberList", listMembers);
			nextPage = "memberList";
			
		} else if(pathInfo.equals("/joinForm")) { // 회원가입폼
			nextPage = "memberJoin";
		} else if(pathInfo.equals("/modifyForm")) { // 회원수정폼
			String id = request.getParameter("id");
			MemberVO memberInfo = dao.findMember(id);
			request.setAttribute("memberInfo", memberInfo);
			nextPage = "memberMod";
		}
		
		else if(pathInfo.equals("/join")) { // 회원가입 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO vo = new MemberVO(id, pwd, name, email);
			dao.addMember(vo);
			String message = URLEncoder.encode(name, "utf-8");
			response.sendRedirect(request.getContextPath() + "/member?msg="+message);
			return;
			
		} else if(pathInfo.equals("/delMember")){ // 삭제 처리
			String paramMno = request.getParameter("mno");
			int mno = Integer.parseInt(paramMno);
			dao.delMember(mno);
			response.sendRedirect(request.getContextPath() + "/member");
			return;
		} else if(pathInfo.equals("/modify")) { // 수정 처리
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO vo = new MemberVO(id, pwd, name, email);
			dao.modMember(vo);
			response.sendRedirect(request.getContextPath() + "/member");
			return;
		}
	
		else { // 404에러
			System.out.println("페이지 찾을 수 없음");
			return;
		}
		
		rd = request.getRequestDispatcher(PRIFIX+nextPage+SUFFIX);
		rd.forward(request, response);
		
	}

}