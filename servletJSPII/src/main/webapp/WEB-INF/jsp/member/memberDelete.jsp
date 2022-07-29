<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <h3>회원정보삭제</h3>
    ${error }

    <form action="<%=request.getContextPath() %>/memberSearch.do" method="post">
        ID: <input type="text" name="id" />
        <input type="hidden" name="job" value="delete" />
        <input type="submit" value="Search" />
    </form>

    <c:set var="mem" value="${member }"></c:set>
    <c:choose>
        <c:when test="${!empty mem }">
            <h3>정보 검색 결과</h3>
            <p>${mem.id }/${mem.passwd }/${mem.name }/${mem.mail }</p>
            <form action="<%=request.getContextPath() %>/memberDelete.do" method="post">
                <input type="hidden" name="id" value="${mem.id }" />
                <input type="submit" value="Del" />
            </form>
        </c:when>
        <c:otherwise>${result }</c:otherwise>
    </c:choose>
</body>

</html>