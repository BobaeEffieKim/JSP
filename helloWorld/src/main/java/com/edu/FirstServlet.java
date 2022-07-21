package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	//부모 클래스가 가진 init()메소드 호출
	@Override
	public void init() throws ServletException {
		//super.init();
		System.out.println("init() 호출.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출.");
	}
}
