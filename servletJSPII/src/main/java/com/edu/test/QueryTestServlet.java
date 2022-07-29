package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");

		out.print("<h1>Post방식</h1>");
		ServletInputStream input = request.getInputStream();
		int len = request.getContentLength();
		System.out.println(len);
		byte[] buf = new byte[len];
		input.readLine(buf, 0, len);
		String str = new String(buf);
		out.print("문자열: " + str);
		out.print("</body></html>");
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
