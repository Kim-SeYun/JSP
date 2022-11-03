package sec03.ex04;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	private static MemberDao dao = new MemberDao();
	private Map<String, String> members = new HashMap<String, String>();
	
	private MemberDao() {
		members.put("mimi", "1234");
		members.put("pepe", "4546");
		members.put("dori", "9571");
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	public boolean login(String id, String pw) {
		String value = members.get(id);
		if(pw.equals(value)) {
			System.out.println("로그인 성공");
			return true;
		}
		return false;
	}

}
