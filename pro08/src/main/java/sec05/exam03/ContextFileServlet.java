package sec05.exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		
		// 루트경로 : webapp
		// 서블릿 컨텍스트는 리소스파일을 읽기 위해 getResourceAsStream 메소드를 제공한다.
		// InputStream(입력스트림) : 데이터가 입력되는 통로 
		InputStream is = ctx.getResourceAsStream("/WEB-INF/bin/init.txt");
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		String menu = null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;
		
		// 버퍼가 가득차거나 개행문자가 나타나면 버퍼의 내용을 전송
		// 버퍼가 가득차지 않는 이상 한줄씩 읽는다.
		while ((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
		
		
		out.print(menu_member +"<br>");
		out.print(menu_order + "<br>");
		out.print(menu_goods + "<br>");
		
		out.close();
		buffer.close();
		
		
		
	}

	

}
