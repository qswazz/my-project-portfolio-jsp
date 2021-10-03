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
	
	<form action="/member/loginAction.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" name="login"/></td>
				<td><input type="button" value="가입하기" onclick="location.href='/member/joinForm.do'"/></td>
				<td><input type="button" value="Home" onclick="location.href='/index.do'"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>