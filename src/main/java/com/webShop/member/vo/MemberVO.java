package com.webShop.member.vo;

import java.util.Date;

public class MemberVO
{
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Date joinDate;
	private String admin;

	
	public MemberVO()
	{
		
	}
	
	
	public MemberVO(String id, String pwd, String name, String email, String phone, Date joinDate, String admin)
	{
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.joinDate = joinDate;
		this.admin = admin;
	}
	
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public Date getJoinDate()
	{
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}

	public String getAdmin()
	{
		return admin;
	}
	
	public void setAdmin(String admin)
	{
		this.admin = admin;
	}
	
}
