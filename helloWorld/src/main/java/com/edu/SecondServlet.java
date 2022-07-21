package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//사용자가 /second.do라는 프로그램을 요청하면 -> 아래 '페이지'실행된다
@WebServlet("/second.do")
public class SecondServlet extends HttpServlet{

	//'페이지' 만들기
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8"); //응답정보에 지금 출력하는 컨텐트 타입 지정
		PrintWriter out = resp.getWriter(); // 출력스트림.
		out.print("<h3>안녕하세요. 서블릿입니다.</h3>"); //출력스트림에 출력될 내용
		
	}
	
	
}
