package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class InitParamServlet extends HttpServlet{
	//서블릿이 호출되면 컨테이너가 하는 역할 => 1. 생성자통해서 생성 -> ServletConfig(서블릿의 파라미터값 읽어들이는)라는 객체가 생성됨 
	//-> init(SC)메소드 실행 -> service(rq,rs)
	
	String id;
	String pw;
	
	public InitParamServlet() {
		System.out.println("InitParamServlet() 호출.");
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		id = config.getInitParameter("id");
		pw = config.getInitParameter("password");
	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");	
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p>ID : "+id+"</p>");
		out.print("<p>Password : "+pw+"</p>");
		out.close();
	}
	
	
}
