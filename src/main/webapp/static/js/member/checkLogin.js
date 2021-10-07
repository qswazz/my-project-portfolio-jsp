function checkLogin()
{
	const inputId = document.getElementById("login-id");
	const inputPwd = document.getElementById("login-pwd");
	
	if(inputId.value == "")
	{
		alert("아이디를 입력하세요.");
		inputId.focus();
		return false;
	}
	
	if(inputPwd.value == "")
	{
		alert("비밀번호를 입력하세요.");
		inputPwd.focus();
		return false;
	}
	
	return true;
}