package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sample02")
public class SampleServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html;charset=utf-8");
   		PrintWriter out = response.getWriter();
   		
   		Enumeration<String> enu = request.getParameterNames();
   		while(enu.hasMoreElements()) {
   			String name = enu.nextElement();
   			if(!name.equals("subject")) {
   				String value = request.getParameter(name);
   				out.print("<h3>"+name+" : "+value+" </h3>");
   				
   			}
   			
   		}
   		
   		String[] subject = request.getParameterValues("subject");
   		for(String sub : subject){
   			out.print("<h3>선택한 과목 : "+sub+"</h3>");
   		}
   		
   		
   	}

	

}
