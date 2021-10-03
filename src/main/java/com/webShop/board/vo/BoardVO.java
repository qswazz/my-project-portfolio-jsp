package com.webShop.board.vo;

public class BoardVO
{
	private int num;
	private String id;
	private String title;
	private String content;
	private int readCount;
	private String writeDate;
	private String modifyDate;
	
	
	public BoardVO()
	{
		
	}
	
	
	public BoardVO(int num, String id, String title, String content, int readCount, String writeDate, String modifyDate)
	{
		super();
		this.num = num;
		this.id = id;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
		this.modifyDate = modifyDate;
	}
	
	
	public int getNum()
	{
		return num;
	}
	
	public void setNum(int num)
	{
		this.num = num;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public int getReadCount()
	{
		return readCount;
	}
	
	public void setReadCount(int readCount)
	{
		this.readCount = readCount;
	}
	
	public String getWriteDate()
	{
		return writeDate;
	}
	
	public void setWriteDate(String writeDate)
	{
		this.writeDate = writeDate;
	}
	
	public String getModifyDate()
	{
		return modifyDate;
	}
	
	public void setModifyDate(String modifyDate)
	{
		this.modifyDate = modifyDate;
	}
	
}
