package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServ extends HttpServlet{

	//init() -> request, response -> service()
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//네트워크정보
		PrintWriter out = resp.getWriter();
		out.print("<h3>네트워크정보</h3>");
		out.print("<p>Request Schema : "+req.getScheme()+"</p>");
		out.print("<p>Server Name : "+req.getServerName()+"</p>");
		out.print("<p>Server Address : "+req.getLocalAddr()+"</p>");
		out.print("<p>Server Port : "+req.getServerPort()+"</p>");
		out.print("<p>Client Address : "+req.getRemoteAddr()+"</p>");
		out.print("<p>Client Host : "+req.getRemoteHost()+"</p>");
		
		String str = "<h3>URL정보</3>";	//요청문서에 대한 정보 
		str += "<p>Request URI : "+req.getRequestURI()+"</p>";
		str += "<p>Request URL : "+req.getRequestURL()+"</p>";
		str += "<p>Context Path : "+req.getContextPath()+"</p>";
		str += "<p>Request Protocol : "+req.getProtocol()+"</p>";
		str += "<p>Servlet Path : "+req.getServletPath()+"</p>";
		
		str += "<h3>요청헤더 정보</h3>";
		Enumeration<String> en=req.getHeaderNames();
		while(en.hasMoreElements()) {
			//가지고 올 요소가 있는지 체크
			//있으면 하나씩 가지고 옴
			String elem= en.nextElement();	//헤드의 정보?
			String headVal = req.getHeader(elem);
			
			str+= "<p>"+elem+","+headVal+"</p>";
		}
		
		out.print(str);
		
		out.close();
	
	}
	
	
}
