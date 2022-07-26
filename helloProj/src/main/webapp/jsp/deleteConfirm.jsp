<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String id= request.getParameter("bno");

	BoardVO vo = new BoardVO();
	vo.setBoardId(Integer.parseInt(id));
	
	BoardDAO dao = new BoardDAO();
	%>
	<script>
		let confm = confirm("정말 삭제하시겠습니까?");
		if(confm==true){
			<%	dao.deleteBoard(vo);%>
		}
<%-- 		confm = <%	dao.deleteBoard(vo);
	
	response.sendRedirect("boardList.jsp");%>  --%>
	</script>
</body>
</html>