package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//세션 만들기
@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = null;
		String param = req.getParameter("p");
		String msg = null;
		
		//생성, 변경, 삭제
			//1.생성
		if(param.equals("create")) {
			session = req.getSession(true); //생성된 세션값이 있으면 session id를 반환, 없으면 새로 생성하여 반환
			if(session.isNew()) {//session이 이전에 만들어진건지 이번에 만들어진건지 알아보는 메소드
				msg = "새로운 세션 객체 생성";
			} else {
				msg = "기존의 세션 객체 반환";
			}
		
		} else if(param.equals("delete")) {
			session = req.getSession(false); //생성된 세션이 있으면 세션반환, 없으면 null
		
			if(session!=null) {
				session.invalidate(); //세션 삭제.
				msg = "세션 객체 삭제";
			} else {
				msg="삭제할 세션 없음";
			}

			
		//msg => 메세지 띄우는 변수 / "msg"=>  setAttribute의 속성 이름 	
			//어트리뷰트를 추가하기위한 값
		} else if(param.equals("add")) { //추가
			session = req.getSession(true);	//디폴드값이 트루
			session.setAttribute("msg", "메세지 추가함");
			msg = "세션 객체에 속성 지정함";
			
		} else if (param.equals("get")) {
			session = req.getSession(false); //세션 객체 없으면 null리턴
			if(session != null) {
				String str = (String)session.getAttribute("msg"); //getAttribute는 리턴타입이 오브젝트 타입
				msg = str;
			} else {
				msg = "데이터를 추출할 세션 없음";
			}
		} else if(param.equals("remove")) {
			session = req.getSession(false);
			if(session != null) {
				session.removeAttribute("msg");
				msg = "객체의 속성을 삭제";
			} else {
				msg = "속성을 제거할 세션 객체 없음";
			}
		}
		resp.getWriter().print("처리결과 : "+msg);
	}
	
}
