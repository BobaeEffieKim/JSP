package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		String hello = "good helo";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");
		out.print("<h1>" + hello + "</h1>");
		out.print("<h2>" + request.getMethod() + "</h2>");
		out.print("<h2>" + request.getPathInfo() + "</h2>");
		out.print("<h2>" + request.getPathTranslated() + "</h2>");
		out.print("<h2>" + request.getQueryString() + "</h2>");
		out.print("<h2>" + request.getContentLength() + "</h2>");

		out.print("<h2>" + request.getContentType() + "</h2>");
		out.print("</html>");
		out.close();

		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			System.out.println("key: " + key + ", " + "val: " + request.getHeader(key));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
