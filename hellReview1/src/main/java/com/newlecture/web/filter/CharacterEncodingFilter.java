package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//1)요청이 오면 흐름을 넘겨서 다음 필터나 서블릿 실행-> 그 결과가 다시 돌아오면 다음 코드 실행
//		System.out.println("before Filter");
//		chain.doFilter(request, response);
//		System.out.println("after Filter");
//		
		//2)모든 서블릿이 실행되기전에 아래가 실행 -> 모든 서블릿은 인코딩 환경을 가지게 됨 
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
}
