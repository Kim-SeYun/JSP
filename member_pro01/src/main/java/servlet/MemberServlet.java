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

@WebServlet("/member/*")
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
		
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String mapping = request.getServletPath();
		uri = uri.substring(ctxPath.length(), uri.length());
		String cmd = uri.substring(mapping.length(), uri.length());
		
		System.out.println(cmd);
		
		
		// 서블릿이 어떤 기능을 수행할지 결정
		if(cmd.equals("/memberList")) {
			List<MemberVO> memberList = dao.memberList();
			request.setAttribute("memberList", memberList);
			RequestDispatcher rd = request.getRequestDispatcher("/mem/memberList.jsp");
			rd.forward(request, response);
		}else if(cmd.equals("/addMember")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			dao.addMember(vo);
			response.sendRedirect("/member_pro01/member/memberList");
		}else if(cmd.equals("/delMember")) {
			String inputMno = request.getParameter("mno");
			try {
				int mno = Integer.parseInt(inputMno);
				dao.delMember(mno);
				response.sendRedirect("member_pro01/member/memberList");
				
			} catch (Exception e) {
				request.getRequestDispatcher("/exception/error.jsp").forward(request, response);
			}
		} else {
			System.out.println("존재하지 않는 페이지");
		}
		
//		if(command!=null && command.equals("addMember")) { // 회원추가
//			MemberVO vo = new MemberVO();
//			vo.setId(request.getParameter("id"));
//			vo.setPwd(request.getParameter("pwd"));
//			vo.setName(request.getParameter("name"));
//			vo.setEmail(request.getParameter("email"));
//			dao.addMember(vo);
//			response.sendRedirect("/member_pro01/member");
//		} else if(command!=null && command.equals("delMember")) {
//			String inputMno = request.getParameter("mno");
//			// 예외처리
//			try {
//				int mno = Integer.parseInt(inputMno);
//				dao.delMember(mno);
//				response.sendRedirect("member_pro01/member");
//				
//			} catch (Exception e) {
//				request.getRequestDispatcher("/exception/error.jsp").forward(request, response);
//			}
//		}
//		
//		else { // 회원조회
//			List<MemberVO> memberList = dao.memberList();
//			request.setAttribute("memberList", memberList);
//			RequestDispatcher rd = request.getRequestDispatcher("/member/memberList.jsp");
//			rd.forward(request, response);
//			
//		}
		
	}
}