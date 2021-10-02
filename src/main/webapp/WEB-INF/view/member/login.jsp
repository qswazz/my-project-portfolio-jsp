<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String err = request.getParameter("err");
	int add = -1;
	if(request.getParameter("add") != null)
	{
		add = Integer.parseInt(request.getParameter("add"));
	}
	
	System.out.println(err + "/" + add);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:set var="err" value="<%=err %>"/>
<c:set var="add" value="<%=add %>"/>

<c:choose>
	<c:when test="${err == '1' }">
		<script>
			window.onload = function()
			{
				alert("로그인 실패")
			}
		</script>
	</c:when>
	
	<c:when test="${add > 0 }">
		<script>
			window.onload = function()
			{
				alert("사용자가 추가되었습니다.")
			}
		</script>
	</c:when>
</c:choose>

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
				<td><input type="button" value="가입하기" onclick="location.href='/member/join.do'"/></td>
			</tr>
		</table>
	</form>
	
</body>
</html>