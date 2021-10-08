<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
	<%
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
		String nowDate = simpleDate.format(date);
	
		session = request.getSession();
	
		String id = (String) session.getAttribute("id");
	%>
	<h3>Board Write View</h3>
	
	<form action="/board?cmd=3" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="board-title"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="id" value="<%= id %>" readonly /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10" cols="100" id="board-content">내용입력하세요.</textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="작성 완료" onclick="return checkBoardWrite()"/></td>
				<td><input type="button" value="목록으로" onclick="location.href='/board?cmd=0'"/></td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript" src="/static/js/board/checkBoardWrite.js"></script>
</body>
</html>