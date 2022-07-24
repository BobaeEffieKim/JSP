package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{

	@Override //서블릿에서 service는 자바에서 main같은 역할 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
			//요청 읽어들일때 한글깨짐 해결 -> 매번 이렇게 하기 귀찮아서 사용하는게 필터!
		//req.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
			
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		out.println(title);
		out.println(content);
		
	}
}
