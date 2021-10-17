<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="/static/css/member/login.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- Header -->
    <jsp:include page="/WEB-INF/view/layout/header.jsp"></jsp:include>
    

    <main id="main">
        <h1 class="main-title">Main</h1>
        <section id="main-login">
            <h1 class="sub-title">Login form</h1>
            <div class="title"> 로그인</div>
            
            <br>
            
            <form id="frm-login" method="post" action="/member?cmd=login">
                <label class="lbl">ID</label>
                <input class="inp" id="input-id" type="text" name="id" placeholder="ID를 입력하세요."/>
                
                <label class="lbl">Password</label>
                <input class="inp" id="input-pwd" type="password" name="pwd" placeholder="Password를 입력하세요."/>

                <nav>
                    <a href="/member?cmd=joinForm">회원가입</a>
                    <ul>
                        <li><a href="#">ID 찾기</a></li>
                        <li><a href="#">Password 찾기</a></li>
                    </ul>
                </nav>
                
                <br>
                <input id="btn-login" type="submit" name="btn-login" value="Login"/>
            </form>
        </section>
    </main>

	
	<script type="text/javascript" src="/static/js/member/login.js"></script>
</body>
</html>