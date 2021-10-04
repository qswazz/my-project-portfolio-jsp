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
	%>
	<h3>Board Detail View</h3>
	
	<table>
		<tr>
			<td>제목</td>
			<td>${item.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${item.id }</td>
		</tr>
		<tr>
			<td>최초 작성 날짜</td>
			<td>${item.writeDate }</td>
		</tr>
		<tr>
			<td>수정 날짜</td>
			<td>${item.modifyDate }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${item.content }</td>
		</tr>
		<tr>
			<c:if test="${id eq item.id }">
				<td><input type="button" value="수정" onclick="location.href='/board?cmd=4&n=${item.num }'"/></td>
				<td><input type="button" value="삭제" onclick="location.href='/board?cmd=6&n=${item.num }'"/></td>
			</c:if>
		</tr>
		<tr>
			<td><input type="button" value="목록으로" onclick="location.href='/board?cmd=0'"/></td>
		</tr>
	</table>
	
</body>
</html>