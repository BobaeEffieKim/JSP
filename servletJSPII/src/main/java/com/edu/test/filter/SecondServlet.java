package com.edu.test.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("secondServlet");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Test Servlet</title></head>");
		out.print("<body><h2>Have nice day!!</h2></body></html>");
		out.close();
	}
}
