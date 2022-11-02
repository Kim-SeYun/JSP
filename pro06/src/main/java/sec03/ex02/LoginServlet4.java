package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void doHandel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doHandel(request, response);
	
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doHandel(request, response);
	
	}

}
