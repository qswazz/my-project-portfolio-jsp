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
	<h3>Board List View</h3>
	
	<form action="/board" method="get">
		<table border=1>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성날짜</th>
			</tr>
			
			<c:forEach var="i" items="${list }">
				<tr>
					<td>${i.num }</td>
					<td><a href="/board?cmd=1&n=${i.num }">${i.title }</a></td>
					<td>${i.id }</td>
					<td>${i.readCount }</td>
					<td>${i.modifyDate }</td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="글쓰기" onclick="location.href='/board?cmd=2'"/>
		<input type="button" value="HOME" onclick="location.href='/index'"/>
	</form>
</body>
</html>