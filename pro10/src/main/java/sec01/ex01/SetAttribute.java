package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctxMsg = "context에 바인딩";
		String sesMsg = "session에 바인딩";
		String reqMsg = "request에 바인딩";
		
		ServletContext ctx = getServletContext(); // 서블릿 컨텍스트 객체
		HttpSession session = request.getSession(); // 세션 객체
		
		ctx.setAttribute("context", ctxMsg); // 서블릿 컨텍스트 객체에 데이터 바인딩
		session.setAttribute("session", sesMsg); // 세션 객체에 데이터 바인딩
		request.setAttribute("request", reqMsg); // 리퀘스트 객체에 데이터 바인딩
		request.getRequestDispatcher("get").forward(request, response);
	}


}