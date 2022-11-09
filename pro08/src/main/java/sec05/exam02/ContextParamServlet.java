package sec05.exam02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		String menu_member = ctx.getInitParameter("menu_member");
		String menu_order = ctx.getInitParameter("menu_order");
		String menu_goods = ctx.getInitParameter("menu_goods");
		
//		out.print(menu_member);
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0<tr>메뉴이름</tr>");
		out.print("<tr><td>" +menu_member+"</tr></td>");
		out.print("<tr><td>" +menu_order+"</tr></td>");
		out.print("<tr><td>" +menu_goods+"</tr></td>");
		out.print("</tr></table></body></html>");
		out.print("");
	
	}

	
	

}
