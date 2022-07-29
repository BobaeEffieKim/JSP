package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context3")
public class ServletContextTest3Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		ServletContext sc = this.getServletContext();

		ShareObject obj1 = new ShareObject();
		obj1.setStr("객체 공유 테스트 - 1");
		obj1.setCount(100);
		sc.setAttribute("data1", obj1);

		ShareObject obj2 = new ShareObject();
		obj2.setStr("객체 공유 테스트 - 2");
		obj2.setCount(200);
		sc.setAttribute("data2", obj2);
		
		out.print("ServletContext객체에 데이터 등록 완료");
		out.close();
	}

}
