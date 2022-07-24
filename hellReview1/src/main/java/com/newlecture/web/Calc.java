package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String x_temp = req.getParameter("x");
		String y_temp = req.getParameter("y");
		
		int x =0; //기본값을 0으로 하겠다는 초기화 -> 만약 빈문자열이 입력되도 0으로 받아짐
		int y =0;
		
		if(!x_temp.equals("")) {
			x = Integer.parseInt(x_temp);
		//만약 문자로 값을 받은 임시x가 빈문자열이 아니라면, x임시를 x에 넣어줘라 / 빈값이면 0으로 보내줌
		}
		if(!y_temp.equals("")) {
			y = Integer.parseInt(y_temp);
		}
		
		int result = x+y;
		resp.getWriter().printf("result is %d\n",result);
	
	}
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//	}
	
}
