<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
</head>
<body>
	<%
		//파라미터를 읽어서 BoardDAO에서 한건 조회기능을 사용해서 화면에 출력하도록 구현하세요.
	
		String bno = request.getParameter("id");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>
	<c:set var="user" value="${id}" />
	<c:set var="vo" value="<%=vo%>"></c:set>
	
	<div>
		<table border="1">
			<thead>
				<tr>
				<th>글번호</th><td>${vo.boardId}</td>
				</tr>
				<tr>
				<th>제목</th><td>${vo.title}</td>
				</tr>
				<tr>
				<th>내용</th><td>${vo.content}</td>
				</tr>
				<tr>
				<th>작성자</th><td>${vo.writer}</td>
				</tr>
				<tr>
				<th>작성일자</th><td>${vo.createDate}</td>
				</tr>
				<tr>
				<th>조회수</th><td>${vo.cnt}</td>
				</tr>
			</thead>

	<!-- 글번호, 제목, 내용, 작성자, 작성일자, 조회수 -->
	
		</table>
		
		<form action="insertCom.jsp" method="post">
			댓글 <textarea name="Commentcontent" cols=30 rows=3></textarea><br>
			작성자 <input type="text" name="id" value="${id }" readonly><br>
			<a href="insertCom.jsp"><input type="submit" value="댓글달기"></a>
		</form>
		<%
		
			String loginId = (String)session.getAttribute("loginId");
			if(loginId != null && loginId.equals(vo.getWriter())){
		%>
		
			<a href="updateForm.jsp?bno=<%=vo.getBoardId()%>">수정화면</a>
			<a href="delete.jsp?bno=<%=vo.getBoardId()%>">삭제화면</a><br>
		<%				
			}
		%>
		
		<br><a href="boardList.jsp?bno=<%=vo.getBoardId() %>">목록으로</a>
<%-- 		<a href= "updateForm.jsp?bno=<%=vo.getBoardId() %>">수정화면</a>
		<a href="delete.jsp?bno=<%=vo.getBoardId() %>">삭제하기</a> --%>
	</div>
</body>
</html>