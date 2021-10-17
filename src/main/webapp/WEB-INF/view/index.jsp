<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="/static/css/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- Header -->
	<jsp:include page="/WEB-INF/view/layout/header.jsp"></jsp:include>


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


	<!-- Footer -->
	<jsp:include page="/WEB-INF/view/layout/footer.jsp"></jsp:include>
	
    
	<!-- Script -->
	<script type="text/javascript" src="/static/js/member/logout.js"></script>
</body>
</html>