package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDaoImpl;

@WebServlet(urlPatterns = {"/AppServlet"}, loadOnStartup = 1)
public class AppServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		ctx.setAttribute("memberDao", MemberDaoImpl.getInstance()); // MemberDao구현체를 서블릿 컨텍스트에 바인딩
		ctx.setAttribute("ctxPath", getServletContext().getContextPath());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}