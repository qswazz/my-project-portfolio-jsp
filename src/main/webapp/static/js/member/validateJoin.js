function validate()
{
	alert("작업 중 입니다.");
}

function init()
{
    const btnValidateId = document.getElementById("btn-validateId");

    btnValidateId.addEventListener("click", validate);
}

init();