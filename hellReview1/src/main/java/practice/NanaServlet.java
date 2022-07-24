package practice;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class NanaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//콘솔창에 출력
		System.out.println("Hello Servlet");
	
		//stream계열로 웹에 출력
//		OutputStream os = resp.getOutputStream();
//		PrintStream out = new PrintStream(os, true);
//		out.println("Hello Servlet");
		
		//문자를 다국어를 쓰겠다 -> writer계열
		PrintWriter out = resp.getWriter();
		out.println("Hello Servlet");
	}
}
