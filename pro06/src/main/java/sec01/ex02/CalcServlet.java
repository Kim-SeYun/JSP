package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	private static float USD_RATE = 1124.70f;
	private static float JPY_RATE = 10.113f;
	private static float CNY_RATE = 163.30f;
	private static float GBP_RATE = 1444.35f;
	private static float EUR_RATE = 1295.97f;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8"); // 마임타입 결정 - 여기서는 HTML문서
		PrintWriter out = response.getWriter(); // 출력 객체를 얻어옴
		
		String command = request.getParameter("command"); // 수행할 요청
		String won = request.getParameter("won"); // 원화값
		String operator = request.getParameter("operator"); // 외화종류
		out.print("");
		if(command!=null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won),operator);
			out.print("<html><title>환율계산기</title><body>");
			out.print("<h2>환율계산기</h2>");
			out.print("<div>변환값 : " +result+ "</div>");
			out.print("<a href='/pro06/calc'>환율계산기</a>");
			return;
		}
		out.print("<html><head><title>환율계산기</title></head>");
		out.print("<body><form action='/pro06/calc'>");
		out.print("<input type=\"text\" name=\"won\">");
		out.print("<select name='operator'>");
		out.print("<option value='dollor'>달러</option>");
		out.print("<option value='en'>엔화</option>");
		out.print("<option value='wian'>위안</option>");
		out.print("<option value='pound'>파운드</option>");
		out.print("<option value='euro'>유로</option>");
		out.print("</select><input type='hidden' name='command' value='calculate'>");
		out.print("<button>변환</button></form></body></html>");
	}

	private String calculate(float won, String operator) {
		
		String result = null;
		if(operator.equals("dollor")) {
			result = String.format("%.6f", won/USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		}else if(operator.equals("wian")){
			result = String.format("%.6f", won/CNY_RATE);
		}else if(operator.equals("pound")){
			result = String.format("%.6f", won/GBP_RATE);
		}else if(operator.equals("euro")){
			result = String.format("%.6f", won/EUR_RATE);
		
		}
		return result;

	}
}