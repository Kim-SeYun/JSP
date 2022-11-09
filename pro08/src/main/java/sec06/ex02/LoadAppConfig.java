package sec06.ex02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/loadConfig"}, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
    
	private ServletContext ctx;
    
    public LoadAppConfig() {
    	System.out.println("LoadAppConfig객체 생성");
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig 초기화 메서드 실행");
		ctx = config.getServletContext();
		String menu_member = ctx.getInitParameter("menu_member");
		
		ctx.setAttribute("menu_member", menu_member);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu_member = (String) ctx.getAttribute("menu_member");
		System.out.println(menu_member);
		
	}

}
