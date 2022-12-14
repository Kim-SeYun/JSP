package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			JSONObject member1 = new JSONObject();
			JSONObject member2 = new JSONObject();
			member1.put("name", "박지성");
			member1.put("age", "25");
			member1.put("gender", "남자");
			member1.put("nick", "두개의 심장");
			
			member2.put("name", "김연아");
			member2.put("age", "20");
			member2.put("gender", "여자");
			member2.put("nick", "피겨여왕");
			
			JSONArray memberArray = new JSONArray();
			memberArray.add(member1);
			memberArray.add(member2);
			
			JSONObject members = new JSONObject();
			members.put("members", memberArray);
			
			out.print(members);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
