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
	
	<h3>Index View</h3>
	<hr>
	<div>
		<h4>회원 관리</h4>
		
		<c:if test="${id == null }">
			<a href="/member/loginForm.do">login</a>
		</c:if>
		
		<c:if test="${id != null }">
			<p>${id }님 안녕하세요!</p>
			<a href="/member/logout.do">logout</a>
		</c:if>
	</div>
	<hr>
	<div>
		<h4>게시판</h4>
		<a href="/member/listForm.do">list</a>
	</div>
	<hr>
	
	<c:if test="${admin.equals('1') }">
		<div>
			<h4>관리자 - 회원관리</h4>
			<a href="/member/listForm.do">admin Member</a>
		</div>
	</c:if>
</body>
</html>