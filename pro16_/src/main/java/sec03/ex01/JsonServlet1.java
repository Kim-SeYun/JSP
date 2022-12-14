package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/json1")
public class JsonServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String jsonInfo = request.getParameter("jsonInfo");
		System.out.println(jsonInfo);
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject member = (JSONObject) jsonParser.parse(jsonInfo);
			System.out.println("이름 : " +member.get("name"));
			System.out.println("나이 : " +member.get("age"));
			System.out.println("성별 : " +member.get("gender"));
			System.out.println("별명 : " +member.get("nick"));
			
			
			out.print("서블릿 응답 : 성공");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
