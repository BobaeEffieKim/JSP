<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//로그인 시도 시 에러메세지 전달
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	BoardDAO dao = new BoardDAO();
	if(dao.loginCheck(id, pwd) == null){
		
		request.setAttribute("msg", "아이디와 비밀번호가 올바른지 확인해주세요.");
		rd.forward(request, response);
		//response.sendRedirect("loginForm.jsp");	 
	} else{
		session.setAttribute("loginId",id);
		response.sendRedirect("boardList.jsp");
	}
	
%>