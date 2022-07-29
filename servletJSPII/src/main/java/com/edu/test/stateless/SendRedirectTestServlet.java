
package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/portalSite")
public class SendRedirectTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("site");
		if (param.equals("naver")) {
			resp.sendRedirect("https://www.naver.com");
		} else if (param.equals("daum")) {
			resp.sendRedirect("https://www.daum.net");
		} else if (param.equals("zum")) {
			resp.sendRedirect("https://www.zum.com");
		} else if (param.equals("google")) {
			resp.sendRedirect("https://www.google.com");
		}
	}

}
