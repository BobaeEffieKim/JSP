<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addBoard.jsp</title>
</head>
<body>
<%-- 	<% 
		
		//글작성할때 글쓴이에 유저이름 자동으로 들어가게
		String user = (String)session.getAttribute("loginId");
		if(user==null || user.equals("")){
			response.sendRedirect("loginForm.jsp");
		}
		
	%> --%>
	
	<c:set var="user" value="${loginId}" />
	<c:if test="${empty user}">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>
	
	<form action="insertBoard.jsp" method="post">
		글제목 : <input type="text" name="title"><br>
		글내용 : <textarea name="content" cols=30 rows=3></textarea><br>
		작성자 : <input type="text" name="writer" value="${user}" readonly><br>
			<input type="submit" value="등록">
			<a href="boardList.jsp"><input type="button" value="취소"></a>
	</form>
</body>
</html>