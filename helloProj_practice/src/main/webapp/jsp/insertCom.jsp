<%@page import="com.tst.comment.CommentDAO"%>
<%@page import="com.tst.comment.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    	request.setCharacterEncoding("UTF-8");
    	String commentContent = request.getParameter("commentContent");
    	String userId = request.getParameter("userId");
    	
    	CommentVO vo = new CommentVO();
    	vo.setCommentContent(commentContent);
    	vo.setUserId(userId);
    	
    	CommentDAO dao = new CommentDAO();
    	dao.insertComment(vo);
    	
    	out.print("completed");
    	response.sendRedirect("boardDetail.jsp");
    	
    %>