package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncoderFilter implements Filter{
	
	ServletContext ctx;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ctx = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("필터 호출");
		request.setCharacterEncoding("utf-8");
		
		// 컨텍스트 패스
		String contextPath = ((HttpServletRequest) request).getContextPath();
		String requestURI = ((HttpServletRequest) request).getRequestURI();
//		String realPath = request.getRealPath(requestURI);
		String realPath = ctx.getRealPath(requestURI);
		
//		System.out.println(contextPath);
//		System.out.println(requestURI);
//		System.out.println(realPath);
		
		chain.doFilter(request, response);
		
	}
	

}
