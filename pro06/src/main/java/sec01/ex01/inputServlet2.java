package sec01.ex01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class inputServlet2 extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = request.getParameter("user_id");
//		String pw = request.getParameter("user_pw");
//		String name = request.getParameter("user_name");
//		String email = request.getParameter("user_email");
//		String address = request.getParameter("user_address");
//		String etc = request.getParameter("etc");
//		System.out.println("아이디 : " + id);
//		System.out.println("비밀번호 : " + pw);
//		System.out.println("이름 : " + name);
//		System.out.println("이메일 : " + email);
//		System.out.println("주소 : " + address);
//		System.out.println("기타사항 : " + etc);
		
		Enumeration<String> enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = enu.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + " : " + value);
		}
		
	}
}

	