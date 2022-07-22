package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet{

		@Override	//get방식 요청 -> 요청정보들이 헤더쪽으로 간다 
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = resp.getWriter();
			
			String id = req.getParameter("id"); //parameter :id값을 반환
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String[] hobby = req.getParameterValues("hobby");	//넘어오는 값이 여러개일 경우 
			String gender = req.getParameter("gender");
			String religion = req.getParameter("religion");
			String intro = req.getParameter("introduction");
			
			out.print("<h3>입력 받은 값</h3>");
			out.print("<p>ID : "+id+"</p>");
			out.print("<p>PW : "+pwd+"</p>");
			out.print("Hobby : <ul>");
			for(int i=0; i<hobby.length; i++) {
				out.print("<li>"+hobby[i]+"</li>");
			}
//			for(String hob : hobby) {
//				out.print("<li>"+hob+"</li>");
//			}
			out.print("</ul>");
			out.print("<p>Gender : "+gender+"</p>");
			out.print("<p>Religion : "+religion+"</p>");
			out.print("<p>Introduction : "+intro+"</p>");
			out.print("질의문자열 : "+req.getQueryString());
			out.close();
		}
	
		@Override	//post방식 -> 요청들이 스트림형식으로 넘어와서 바디로 들어감
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = resp.getWriter();
			
//			String id = req.getParameter("id"); //parameter :id값을 반환
//			String pwd = req.getParameter("pwd");
//			String name = req.getParameter("name");
//			String[] hobby = req.getParameterValues("hobby");	//넘어오는 값이 여러개일 경우 
//			String gender = req.getParameter("gender");
//			String religion = req.getParameter("religion");
//			String intro = req.getParameter("introduction");
//			
//			out.print("<h3>입력 받은 값</h3>");
//			out.print("<p>ID : "+id+"</p>");
//			out.print("<p>PW : "+pwd+"</p>");
//			out.print("<p>Name : "+name+"</p>");
//			out.print("Hobby : <ul>");
//			for(int i=0; i<hobby.length; i++) {
//				out.print("<li>"+hobby[i]+"</li>");
//			}
////			for(String hob : hobby) {
////				out.print("<li>"+hob+"</li>");
////			}
//			out.print("</ul>");
//			out.print("<p>Gender : "+gender+"</p>");
//			out.print("<p>Religion : "+religion+"</p>");
//			out.print("<p>Introduction : "+intro+"</p>");
			
			ServletInputStream sis = req.getInputStream();	//post방식일 경우 : 들어오는 정보들이 '입력스트림'으로 들어옴
			int len = req.getContentLength();	//데이터 크기를 담아주는 변수
			
			byte[] buf = new byte[len];	//버프의 크기를 넘어온 데이터크기만큼 선언
			sis.readLine(buf, 0, len); //buf의 처음부터 끝까지 읽겠다
			String queryString = new String(buf);
			System.out.println(queryString);
			out.print("<p id='queryString'>"+ queryString+"</p>");
			sis.close();
			out.close();
		}
	
	
}
