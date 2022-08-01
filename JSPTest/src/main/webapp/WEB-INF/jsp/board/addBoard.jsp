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

<%-- 	<c:set var="user" value="${MemberloginId }"></c:set>
	<c:if test="${empty user}">
		<c:redirect url="MemberloginForm.jsp"></c:redirect>
	</c:if> --%>
	
	<form action="insertBoard.do" method="post">
		글제목 : <input type="text" name="title"><br>
		글내용 : <textarea name="content" cols=30 rows=3></textarea><br>
		작성자 : <input type="text" name="writer" ><br>
			<input type="submit" value="등록">
			<a href="boardList.jsp"><input type="button" value="취소"></a>
	</form>
</body>
</html>