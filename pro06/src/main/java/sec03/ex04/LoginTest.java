package sec03.ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.DocumentHandler;


@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
       
    
	private MemberDao dao = MemberDao.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String result = dao.login(id, pw);
		System.out.println("결과 : " + result);
		
	}
}
