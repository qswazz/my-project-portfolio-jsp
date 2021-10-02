<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Detail View</h3>
	
	<form action="/member/detailAction.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${vo.id}" readonly/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${vo.name }"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${vo.email }"/></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${vo.phone }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"/></td>
				<td><input type="button" value="뒤로가기" onclick="history.go(-1)"/></td>
			</tr>
		</table>
	</form>
</body>
</html>