<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:if test="${!empty result }">${result }</c:if>
	<c:if test="${!empty member }">${member.id }/${member.name }/${member.passwd }/${member.mail }</c:if>
	<h3></h3>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>