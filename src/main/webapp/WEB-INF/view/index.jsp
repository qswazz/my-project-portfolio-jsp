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
	<h3>Index View</h3>
	
	<a href="/member/list.do">list</a>
	
	<c:if test="${id }">
	
	</c:if>
	
	<a href="/member/login.do">login</a>
	<a href="/member/join.do">join</a>
</body>
</html>