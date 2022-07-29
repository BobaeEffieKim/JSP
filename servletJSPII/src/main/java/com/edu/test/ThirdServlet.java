package com.edu.test;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getServletContext().getContextPath() + req.getRequestURI());
		System.out.println(req.getServletPath());
		
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getCharacterEncoding());
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println(resp.getContentType());
		System.out.println(resp.getCharacterEncoding());

		System.out.println("enumeration ------------------");
		Enumeration<String> co = req.getHeaderNames();
		while (co.hasMoreElements()) {
			String key = co.nextElement();
			System.out.println("key: " + key);
			Collection<String> col = resp.getHeaders(key);
			for (String str : col) {
				System.out.println("str: " + resp.getHeader(str));
			}
		}
	}
}
