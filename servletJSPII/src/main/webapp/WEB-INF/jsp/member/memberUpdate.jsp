<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>회원정보 수정</h3>
	${error }

	<form action="<%=request.getContextPath() %>/memberSearch.do" method="post">
		ID: <input type="text" name="id" />
		 <input type="hidden" name="job" value="update" /> 
		 <input type="submit" value="Search" />
	</form>

	<%
	MemberVO member = (MemberVO) request.getAttribute("member");
	if (member != null) {
	%>
	<h3>회원정보수정</h3>
	<form action="<%=request.getContextPath() %>/memberUpdate.do" method="post">
		ID: <input type="text" name="id" readonly value="${member.id }"><br>
		PW: <input type="password" name="passwd" value="${member.passwd }"><br>
		Name: <input type="text" name="name" value="${member.name }"><br>
		Mail: <input type="email" name="mail" value="${member.mail }"><br>
		<input type="submit" value="Modify">
	</form>
	<%
	} else {
	%>
	<p>${result }</p>
	<%
	}
	%>

</body>
</html>