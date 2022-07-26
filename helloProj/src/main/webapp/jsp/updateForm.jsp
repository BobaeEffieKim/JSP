<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%
		/* request||response 등은 내장객체이다! 	/	 getParameter는 문자열타입 */
		String bno = request.getParameter("bno");	
		BoardDAO dao = new BoardDAO();
		System.out.println(bno);
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>
	<form action="update.jsp">
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="<%=vo.getBoardId() %>" readonly></td></tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="<%=vo.getTitle() %>"></td></tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="<%=vo.getContent() %>"></td></tr>
		<tr><th>작성자</th><td><input type="text" name="writer" value="<%=vo.getWriter() %>" readonly></td></tr>
		<tr><th>작성일자</th><td><input type="text" name="bdate" value="<%=vo.getCreateDate() %>" readonly></td></tr>
		<tr><td colspan="2"><input type="submit" value="수정"></td></tr>
	</table>
	</form>
</body>
</html>