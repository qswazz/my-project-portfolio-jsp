const form = document.getElementById("login-form");
const btnLogin = document.getElementById("btn-login");


function checkLogin()
{
	const inputId = form.getElementById("login-id");
	const inputPwd = form.getElementById("login-pwd");
	
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


function clickLogin()
{
	console.log("???");
	if(checkLogin() == true)
	{
		location.href = "/member?cmd=1";
	}
}


btnLogin.addEventListener('click', clickLogin);
