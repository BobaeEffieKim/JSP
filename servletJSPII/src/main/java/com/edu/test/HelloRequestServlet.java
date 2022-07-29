package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloRequestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		String hello = "good helo";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");
		out.print("<h1>" + hello + "</h1>");
		out.print("<h2>" + request.getMethod() + "</h2>");
		out.print("<h2>" + request.getPathInfo() + "</h2>");
		out.print("<h2>" + request.getPathTranslated() + "</h2>");

		out.print("<h2>" + request.getContentLength() + "</h2>");

		out.print("<h2>" + request.getContentType() + "</h2>");
		out.print("</html>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		String hello = "good helo";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");
		out.print("<h1>Request정보출력</h1>");
		out.print("<h1>" + hello + "</h1>");
		out.print("<h2>" + request.getMethod() + "</h2>");
		out.print("<h2>" + request.getPathInfo() + "</h2>");
		out.print("<h2>" + request.getPathTranslated() + "</h2>");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println(id + ", " + name);
		out.print("<h2>" + name + ", " + id + "</h2>");

		ServletInputStream input = request.getInputStream();
		int len = request.getContentLength();
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf, "UTF-8");
		out.print("<h2>" + str + "</h2>");
		System.out.println(str);

		out.print("<h2>" + request.getContentLength() + "</h2>");
		out.print("<h2>" + request.getContentType() + "</h2>");
		out.print("</html>");
		out.close();

	}

}
