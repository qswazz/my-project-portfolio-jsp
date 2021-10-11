function validLogin(id, pwd)
{
	const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
	
	if(id.value == "")
	{
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	
	if(id.value.length < 5
		|| regExp.test(id.value))
	{
		alert("유효하지 않은 아이디 형식입니다.");
		id.focus();
		return false;
	}
	
	if(pwd.value == "")
	{
		alert("비밀번호를 입력하세요.");
		pwd.focus();
		return false;
	}
	
	if(pwd.value.length < 5)
	{
		alert("유효하지 않은 비밀번호 형식입니다.");
		id.focus();
		return false;
	}
	
	console.log("Success");
	return true;
}

function init()
{
	const btnLogin = document.getElementById("btn-login");

	var id = document.getElementById("input-id");
	var pwd = document.getElementById("input-pwd");

	btnLogin.addEventListener('click', ()=>validLogin(id, pwd));
}

init();

// const form = document.getElementById("login-form");
// const btnLogin = document.getElementById("btn-login");


// function checkLogin()
// {
// 	const inputId = form.getElementById("login-id");
// 	const inputPwd = form.getElementById("login-pwd");
	
// 	if(inputId.value == "")
// 	{
// 		alert("아이디를 입력하세요.");
// 		inputId.focus();
// 		return false;
// 	}
	
// 	if(inputPwd.value == "")
// 	{
// 		alert("비밀번호를 입력하세요.");
// 		inputPwd.focus();
// 		return false;
// 	}
	
// 	return true;
// }


// function clickLogin()
// {
// 	console.log("???");
// 	if(checkLogin() == true)
// 	{
// 		location.href = "/member?cmd=1";
// 	}
// }


// btnLogin.addEventListener('click', clickLogin);
