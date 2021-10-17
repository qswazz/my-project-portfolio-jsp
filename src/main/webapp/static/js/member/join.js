const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;

function valid(e)
{
    var id = document.getElementById("input-id");
    var pwd = document.getElementById("input-pwd");
    var pwd2 = document.getElementById("input-pwd2");
    var name = document.getElementById("input-name");
	
	if(id.value == "")
	{
        e.preventDefault();
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	
	if(id.value.length < 5
		|| regExp.test(id.value))
	{
        e.preventDefault();
		alert("유효하지 않은 아이디 형식입니다.");
		id.focus();
		return false;
	}
	
	if(pwd.value == "")
	{
        e.preventDefault();
		alert("비밀번호를 입력하세요.");
		pwd.focus();
		return false;
	}

	if(pwd2.value == "")
	{
        e.preventDefault();
		alert("비밀번호 확인을 입력하세요.");
		pwd2.focus();
		return false;
	}

	if(pwd.value != pwd2.value)
	{
        e.preventDefault();
		alert("비밀번호가 일치하지 않습니다.");
		pwd2.focus();
		return false;
	}

	if(name.value == "")
	{
        e.preventDefault();
		alert("이름을 입력하세요.");
		name.focus();
		return false;
	}
	
	return true;
}

function init()
{
    const frm = document.getElementById("frm-join");

    frm.addEventListener("submit", valid);
}

init();