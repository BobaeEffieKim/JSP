package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{

	@Override //서블릿에서 service는 자바에서 main같은 역할 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		//http://localhost:8088/hellReview1/nana?cnt=4 -> 쿼리스트링으로 옵션 지정
			//위와 같이 클라이언트가 요청할때 특정 옵션으로 하고자 하는 경우
			//요청에 getParameter 사용 -> 문자열이기때문에 정수값으로 사용할때는 강제 변환
			//http://localhost:8088/hellReview1/nana 만 입력하면 500번 오류남 ->옵션값(쿼리스트링)줘야함
		
		//쿼리스트링(질의문자열) 
			//hello?cnt=3	-> "3" 출력됨 
			//hello?cnt=	-> "" 빈문자열 출력됨
			//hello?		-> null
			//hello			-> null 
//		int cnt = Integer.parseInt(req.getParameter("cnt"));
		
		String temp = req.getParameter("cnt");
		int cnt =100;	//기본값으로 초기화 해놓음 -> 그럼 처음실행되면 쿼리가 없기때문에 100번 출력됨
		
		//temp가 널이 아니고, 빈문자열이 아닐경우, 정수값으로 변환해서 cnt에 담아라 
		if(temp!=null && !temp.equals("")) {
			cnt = Integer.parseInt(temp);
		}
		
		for(int i=0; i<cnt; i++) {
			
			out.println((i+1)+" : 안녕 Servlet!!<br>") ;
		}
	}
}
