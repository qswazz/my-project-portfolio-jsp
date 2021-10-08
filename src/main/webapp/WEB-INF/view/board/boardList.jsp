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
		String id = (String) session.getAttribute("id");
		String admin = (String) session.getAttribute("admin");
	%>
	<h3>Board List View</h3>
	
	<form action="/board" method="get">
		<table border=1>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성날짜</th>
				<c:if test="${admin eq 0 }">
					<th>관리자 항목</th>
				</c:if>
			</tr>
			
			<c:forEach var="i" items="${list }">
				<tr>
					<td>${i.num }</td>
					<td><a href="/board?cmd=1&n=${i.num }">${i.title }</a></td>
					<td>${i.id }</td>
					<td>${i.readCount }</td>
					<td>${i.modifyDate }</td>
					<c:if test="${admin eq 0 }">
						<td><a href='/board?cmd=6&n=${i.num }'>삭제</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		
		<c:if test="${id != null }">
			<input type="button" value="글쓰기" onclick="location.href='/board?cmd=2'"/>
		</c:if>
		<input type="button" value="HOME" onclick="location.href='/index'"/>
	</form>
</body>
</html>