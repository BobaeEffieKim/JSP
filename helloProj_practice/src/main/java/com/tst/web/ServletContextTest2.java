package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ServletContextTest2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext sc = getServletContext();
		out.print("<p>서블릿 버전 : "+sc.getMajorVersion()+"</p>");
		out.print("<p>서버정보 : "+sc.getServerInfo()+"/<p>");
		out.print("앱 경로 : "+sc.getContextPath()+"</p>");
		out.print("앱 이름 : "+sc.getServletContextName()+"</p>");
		out.print("페이지 경로 : "+sc.getRealPath("form.html")+"</p>");
		sc.log("로그 기록 중입니다.");
		
		out.close();
	}
	
}
