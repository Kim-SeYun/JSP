package sec04.ex03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/list")
public class MemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList.add(new MemberVO("홍길동", "hong@example"));
		memberList.add(new MemberVO("신용권", "sin@example"));
		memberList.add(new MemberVO("남궁성", "nam@example"));
		memberList.add(new MemberVO("박재성", "park@example"));
		
		req.setAttribute("members", memberList);
		
		RequestDispatcher rd = req.getRequestDispatcher("/member/view");
		rd.forward(req, resp);
	
	}

}

class MemberVO{
	private String name;
	private String email;
	
	public MemberVO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
