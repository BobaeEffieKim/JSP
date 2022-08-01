<%@page import="co.edu.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty loginId}">
			<h3><c:out value="${loginId}"></c:out>님으로 로그인했습니다.</h3>
	         <a href="logout.jsp"><input type="button" value="로그아웃"></a>
		</c:when>
		<c:otherwise>
			<h3>손님입니다.</h3>
         	<a href="login.jsp"><input type="button" value="로그인"></a>
		</c:otherwise>
	</c:choose>
	

	<div>
		
		<table border="1">
			<thead>
				<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
				</tr>
			</thead>
			<tbody>
			
			
			
				<c:forEach var="vo" items="${board}">
				
				
					<tr>
					<td><a href="boardDetail.jsp?id=${vo.seq}">${vo.seq}</a></td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.writeDate}</td>
					<td>${vo.visitCnt}</td>
					</tr>
				</c:forEach>
			<%
				
				//}
			%>		
			
			</tbody>
		</table>
		<!-- <a href="addBoard.jsp"><input type="button" value="글작성"></a> -->
	</div>

</body>
</html>