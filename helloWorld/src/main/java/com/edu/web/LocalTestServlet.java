package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/local")
public class LocalTestServlet extends HttpServlet{

	String str;	//필드(멤버변수, 전역변수)로 선언 => 같이 공유하고 있음 -> 한 요청 실행되다가 다른 요청 들어오면 겹침(?) => 메모리 많이 잡아먹음 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String str =~; 안에서 선언하면 로컬변수로 선언 => 스레드가 각각 독립적으로 만들어져서 만들어진 스레드 안에 값을 담음 
			//=>요청이 동시에 들어와도 요청들 간 간섭받지않고 각각 실행됨 
		str = req.getParameter("msg");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h2>처리결과(지역변수)</h2>");

		int num = 0;
		while(num++ < 10) {
			out.print(str + " : " + num + "<br>");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		out.print("<h2>Done : "+str+"</h2>");
	}
	
}
