function checkBoardWrite()
{
	const title = document.getElementById("board-title");
	const content = document.getElementById("board-content");
	
	if(title.value == "")
	{
		alert("제목을 입력하세요.");
		return false;
	}
	
	if(content.value == "")
	{
		alert("내용을 입력하세요.");
		return false;
	}
	
	return true;
}