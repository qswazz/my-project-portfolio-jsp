function showMessage()
{
	var isLogout = confirm("로그아웃 하시겠습니까?");
	
	console.log("Logout click");
	
	if(isLogout)
	{
		location.href = "/member?cmd=logout";
	}
}

function init()
{
    const btnLogout = document.getElementById("btn-logout");

    btnLogout.addEventListener("click", showMessage);
}

init();