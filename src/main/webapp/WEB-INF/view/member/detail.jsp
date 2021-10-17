<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link href="/static/css/member/detail.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<%
		String isResult = (String) request.getAttribute("showMessage");
	
		System.out.println("showMessage : " + isResult);
	%>

	<!-- Header -->
    <jsp:include page="/WEB-INF/view/layout/header.jsp"></jsp:include>

    <main id="main">
        <h1 class="main-title">Main</h1>
        <section id="main-detail">
            <h1 class="sub-title">Detail form</h1>
            <div class="title">회원정보 수정</div>
            <br>
            <form id="frm-detail" method="post" action="/member?cmd=detail">
                <label class="lbl">아이디</label>
                <input class="inp" id="input-id" type="text" name="id" value="${userInfo.id }" readonly/>
                
                <label class="lbl">비밀번호</label>
                <input class="inp" id="input-pwd" type="password" name="pwd"/>

                <label class="lbl">비밀번호 확인</label>
                <input class="inp" id="input-pwd2" type="password" name="pwd2"/>

                <label class="lbl">이름</label>
                <input class="inp" id="input-name" type="text" name="name" value="${userInfo.name }"/>
                
                <label class="lbl">이메일</label>
                <input class="inp" id="input-email" type="text" name="email" value="${userInfo.email }"/>
                
                <label class="lbl">전화번호</label>
                <input class="inp" id="input-phone" type="text" name="phone" value="${userInfo.phone }"/>
                
                <br>
                <input id="btn-detail" type="submit" name="btn-detail" value="수정하기"/>
            </form>
        </section>
    </main>

    
	<!-- Script -->
	<script type="text/javascript" src="/static/js/member/detail.js"></script>
	<script type="text/javascript" src="/static/js/member/logout.js"></script>
</body>
</html>