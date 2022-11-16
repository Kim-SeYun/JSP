package sec04.ex01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginVO implements HttpSessionBindingListener{
	
	// 중복허용X, 순서없음(index없음)
	public static Set<String> logined = new HashSet<String>();
	
	private String user_id;
	
	public LoginVO(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("세션객체에 데이터가 바인딩 됨");
		logined.add(user_id);
		System.out.println(logined);
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logined.remove(user_id);
		System.out.println(logined);
	}
	
	
}