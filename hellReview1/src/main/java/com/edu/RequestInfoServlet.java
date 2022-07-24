package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		//네트워크 정보
		PrintWriter out = resp.getWriter();
		out.print("<h3>네트워크 정보</h3>");
		out.print("<p>Request Schema : "+req.getScheme()+"</p>");
		out.print("<p>Server Name : "+req.getServerName()+"</p>");
		out.print("<p>Server Address : "+req.getLocalAddr()+"</p>");
		out.print("<p>Server Port : "+req.getServerPort()+"</p>");
		out.print("<p>Client Address : "+req.getRemoteAddr()+"</p>");
		out.print("<p>Client Host : "+req.getRemoteHost()+"</p>");
		out.print("<p>Client Port : "+req.getRemotePort()+"</p>");
	
		String str = "<h3>URL 정보</h3>";
		str += "<p>Request URI : "+req.getRequestURI()+"</p>";
		str += "<p>Request URL : "+req.getRequestURL()+"</p>";
		str += "<p>Context Path : "+req.getContextPath()+"</p>";
		str += "<p>Request Protocol : "+req.getProtocol()+"</p>";
		str += "<p>Servlet Path : "+req.getServletPath()+"</p>";
	
		out.print(str);
		out.close();
	}
	
}
