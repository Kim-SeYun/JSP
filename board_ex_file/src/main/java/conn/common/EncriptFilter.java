package conn.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/member/join")
public class EncriptFilter extends HttpFilter implements Filter {
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("암호필터 동작");
		String pwd = request.getParameter("pwd");
		if(pwd!=null) {
			pwd = pwd+"!@#$%";
			request.setAttribute("pwd", pwd);
		}
		
		chain.doFilter(request, response);
	}

	

}
