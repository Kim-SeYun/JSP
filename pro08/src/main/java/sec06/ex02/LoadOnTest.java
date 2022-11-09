package sec06.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {"/loadOntest"}, loadOnStartup = 1)
public class LoadOnTest extends HttpServlet{
	
	public LoadOnTest() {
		System.out.println("LoadOnTest객체 생성");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LoadOnTest : init 메서드 호출");
	
	}

}
