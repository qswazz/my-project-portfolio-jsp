package com.webShop.member.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.member.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;
import com.webShop.service.IService;

public class LoginActionService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session = request.getSession();
		
		String nextPage = null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO userInfo = dao.getMember(id);
		
		if(pwd.equals(userInfo.getPwd()))
		{
			session.setAttribute("id", userInfo.getId());

			nextPage = "/index.do";
		}
		else
		{
			nextPage = "/member/loginForm.do?err=1";
		}
		
		return nextPage;
	}
}
