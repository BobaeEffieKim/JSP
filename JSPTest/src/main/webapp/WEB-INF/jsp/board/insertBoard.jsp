<%@page import="co.edu.dao.BoardDAO"%>
<%@page import="co.edu.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%



	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	
	BoardVO vo = new BoardVO();
	vo.setTitle(title);
	vo.setContent(content);
	vo.setWriter(writer);
	
	BoardDAO dao = new BoardDAO();
	dao.insertBoard(vo);
	
	out.print("completed");
	response.sendRedirect("boardList.jsp");




%>