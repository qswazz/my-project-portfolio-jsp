<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link href="/static/css/layout/header.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String admin = (String) session.getAttribute("admin");
	%>
	
    <header id="header">
        <h1 class="main-title">Header</h1>
        <nav id="header-toolbar">
            <h1 class="sub-title">Header toolbar</h1>
            <ul>
            	<c:choose>
            		<c:when test="${id == null }">
            			<li><a href="/member?cmd=loginForm">로그인</a></li>
                		<li><a href="/member?cmd=joinForm">회원가입</a></li>
            		</c:when>
            		<c:when test="${id != null }">
            			<li>${id }님 안녕하세요!</li>
            			<li><a href="/member?cmd=detailForm&id=${id }">회원정보</a></li>
            			<li><a id="btn-logout">로그아웃</a></li>
            		</c:when>
            	</c:choose>
                
                <li><a href="/index">Home</a></li>
            </ul>
        </nav>

        <section id="header-menu">
            <h1 class="sub-title">Header Menu</h1>
            <a href="/index"><img src="/static/images/default.jpg" alt="" width="100px"></a>
            <ul>
                <li><a href="/static/html/board/boardList.html">공지사항</a></li>
                <li><a href="#">일정 목록</a></li>
                <li><a href="#">게시판3</a></li>
            </ul>
        </section>
    </header>
</body>
</html>