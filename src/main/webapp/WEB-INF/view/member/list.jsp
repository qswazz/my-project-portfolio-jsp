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
	<h3>List View</h3>

	<h2>안녕하세요. ${vo.name }님 !!</h2>	

	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입날짜</th>
		</tr>
		
		<c:forEach var="i" items="${list }">
			<tr>
				<td>${i.id }</td>
				<td>${i.pwd }</td>
				<td>${i.name }</td>
				<td>${i.email }</td>
				<td>${i.phone }</td>
				<td>${i.joinDate }</td>
			</tr>
		</c:forEach>
	</table>

	<form action="" method="post">
		<input type="button" value="회원정보 수정" onclick="location.href='/member/detail.do'"/>
		<input type="button" value="back" onclick="history.go(-1)"/>
	</form>
</body>
</html>