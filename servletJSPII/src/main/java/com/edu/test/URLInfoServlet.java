package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlInfo")
public class URLInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + req.getRequestURI());
		System.out.println(req.getServletPath());

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<head><title>Request 정보 출력</title></head>");
		out.print("<body>");
		out.print("" + req.getRequestURI());
		out.print(req.getRequestURL());
		out.print(req.getContextPath());
		out.print(req.getProtocol());
		out.print(req.getServletPath());
		out.print("</body></html>");
		out.print("text/tml");
//	out.close();}
	}
}
