package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/additionalInfoServlet")
public class AdditionalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionalInfoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + request.getRequestURI());
		System.out.println(request.getServletPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Request정보출력</title></head>");
		out.print("<body>");
		out.print("<h2>" + request.getMethod() + "</h2>");
		out.print("<h2>" + request.getPathInfo() + "</h2>");
		out.print("<h2>" + request.getPathTranslated() + "</h2>");
		out.print("<h2>" + request.getQueryString() + "</h2>");
		out.print("<h2>" + request.getContentLength() + "</h2>");
		out.print("<h2>" + request.getContentType() + "</h2>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
