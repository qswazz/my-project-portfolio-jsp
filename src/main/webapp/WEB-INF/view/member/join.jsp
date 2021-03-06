<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link href="/static/css/member/join.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- Header -->
    <jsp:include page="/WEB-INF/view/layout/header.jsp"></jsp:include>
    

    <main id="main">
        <h1 class="main-title">Main</h1>
        <section id="main-join">
            <h1 class="sub-title">Join form</h1>
            <div class="title">회원가입</div>
            <br>
            <form id="frm-join" method="post" action="/member?cmd=join">
            	<p class="info">(* 표시 항목은 필수 입력값입니다.)</p>
                <label class="lbl">아이디*</label>
                <div>
                    <input class="inp" id="input-id" type="text" name="id" placeholder="ID를 입력하세요."/>
                    <input class="btn" id="btn-validateId" type="button" value="중복확인"/>
                </div>
                
                <label class="lbl">비밀번호*</label>
                <input class="inp" id="input-pwd" type="password" name="pwd" placeholder="Password를 입력하세요."/>

                <label class="lbl">비밀번호 확인*</label>
                <input class="inp" id="input-pwd2" type="password" name="pwd2"/>

                <label class="lbl">이름*</label>
                <input class="inp" id="input-name" type="text" name="name"/>
                
                <label class="lbl">이메일</label>
                <input class="inp" id="input-email" type="text" name="email"/>
                
                <label class="lbl">전화번호</label>
                <input class="inp" id="input-phone" type="text" name="phone" placeholder="'-' 까지 입력하세요."/>
                
                <br>
                <input id="btn-join" type="submit" name="btn-join" value="가입하기"/>
            </form>
        </section>
    </main>
	
	<script type="text/javascript" src="/static/js/member/join.js"></script>
	<script type="text/javascript" src="/static/js/member/validateJoin.js"></script>
</body>
</html>