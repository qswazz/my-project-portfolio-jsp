package com.webShop.member.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.common.service.IService;

public class LoginFormService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/WEB-INF/view/member/login.jsp";
		
		return url;
	}

}
