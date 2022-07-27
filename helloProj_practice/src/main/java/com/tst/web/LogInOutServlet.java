package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println(id);
		
		if(id.isEmpty() || pwd.isEmpty()) {
			out.print("ID와 PW를 입력해주세요.");
			return;
		}
		HttpSession session = req.getSession();
		if(session.isNew() || session.getAttribute("id")==null) {
			//새로 만들어졌거나 || 아이디속성을 읽어왔지만 널일 경우
			session.setAttribute("id", id);
			out.print("로그인을 완료했습니다.");
			
			//로그인하면 게시판 목록으로 가기 
//			req.setAttribute("param1", id);
//			req.setAttribute("param2", pwd);
//			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("jsp/boardList.jsp");
//			rd.forward(req, resp);
//			
			resp.sendRedirect("jsp/boardList.jsp");
			
			
		} else {
			out.print("현재 로그인 중입니다.");
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		if(session!=null && session.getAttribute("id")!=null) {
			//이미 로그인 되어 있다는 의미
			
			session.invalidate();	//세션 삭제
			out.print("로그아웃 완료했습니다.");
		} else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
	}
}
