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
	}

	private String calculate(float won, String operator) {
		// 외화의 종류에 따른 계산
		return "테스트값";
	}
}