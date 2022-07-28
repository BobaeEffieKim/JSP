<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제검색(memberDelete.jsp)</title>
</head>
<body>
	<h3>회원삭제</h3>
	${error}
	<form action="${pageContext.request.contextPath }/memberSearch.do" method="post">
		아이디 : <input type="text" name="id"><br>
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="조회">
	</form>
	
 	<c:set var="vo" value="${member}"/>
	<c:choose>
	<c:when test="${!empty vo }">
		<form action="${pageContext.request.contextPath }/memberDelete.do" method="post">
			<h4>${vo.id }님의 계정을 정말로 삭제하시겠습니까?</h4>
			
 			<input type="hidden" name="id" value="${vo.id }" readonly><br>
			<input type="hidden" name="passwd" value="${vo.passwd }" ><br>
			<input type="hidden" name="name" value="${vo.name }" ><br>
			<input type="hidden" name="mail" value="${vo.mail }" ><br>
			
 			<input type="submit" value="삭제">
 			<a href="index.jsp"><input type="button" value="취소"></a>
		</form>
	</c:when>
	<c:otherwise>
		<p>${result }</p>
	</c:otherwise>
	</c:choose>
	 
	
	
</body>
</html>