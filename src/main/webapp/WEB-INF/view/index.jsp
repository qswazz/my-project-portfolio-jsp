<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="/static/css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String admin = (String) session.getAttribute("admin");
		
		System.out.println("id: " + id);
		System.out.println("admin: " + admin);
	%>
	
    <header id="header">
        <h1 class="main-title">Header</h1>
        <nav id="header-toolbar">
            <h1 class="sub-title">Header toolbar</h1>
            <ul>
            	<c:choose>
            		<c:when test="${id == null }">
            			<li><a href="/member?cmd=loginForm">로그인</a></li>
                		<li><a href="member/join.html">회원가입</a></li>
            		</c:when>
            		<c:when test="${id != null }">
            			<li>${id }님 안녕하세요!</li>
            			<li><a href="#">회원정보</a></li>
            			<li><a href="#">로그아웃</a></li>
            		</c:when>
            	</c:choose>
                
                <li><a href="/index">Home</a></li>
            </ul>
        </nav>

        <section id="header-menu">
            <h1 class="sub-title">Header Menu</h1>
            <a href="/static/html/index.html"><img src="/static/images/default.jpg" alt="" width="100px"></a>
            <ul>
                <li><a href="/static/html/board/boardList.html">공지사항</a></li>
                <li><a href="#">일정 목록</a></li>
                <li><a href="#">게시판3</a></li>
            </ul>
        </section>
    </header>

    <hr>

    <div id="visual">
        <h1 class="main-title">Visual</h1>
        <ul>
            <li><a href="#"><img src="/static/images/default-banner.jpg" alt=""></a></li>
        </ul>
    </div>

    <main id="main">
        <h1 class="main-title">Main</h1>
        <section class="main-content">
            <h1 class="content-title"><a href="/static/html/board/boardList.html">공지사항</a></h1>
            <hr>
            <ul>
                <li><a href="#">공지사항을 읽어주세요.</a></li>
                <li><a href="#">안녕하세요?</a></li>
                <li><a href="#">공지사항3</a></li>
            </ul>
        </section>

        <section class="main-content">
            <h1 class="content-title">일정 목록</h1>
            <ul>
                <li><a href="#">일정1</a></li>
                <li><a href="#">일정2</a></li>
                <li><a href="#">일정3</a></li>
            </ul>
        </section>
    </main>

    <footer id="footer">
        <h1 class="main-title">Footer</h1>
        <div>
            Footer입니다.
        </div>
    </footer>
    
</body>
</html>