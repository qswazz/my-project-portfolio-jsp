package com.webShop.member.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;

public class LogoutService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/index";
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return url;
	}

}
