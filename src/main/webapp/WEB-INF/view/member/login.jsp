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
	<h3>Login View</h3>
	
	<form action="/member?cmd=1" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="login-id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" id="login-pwd"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" name="login" onclick="return checkLogin()"/></td>
				<td><input type="button" value="가입하기" onclick="location.href='/member?cmd=3'"/></td>
				<td><input type="button" value="Home" onclick="location.href='/index'"/></td>
			</tr>
		</table>
	</form>
	
	 <script type="text/javascript" src="/static/js/member/checkLogin.js"></script>
</body>
</html>