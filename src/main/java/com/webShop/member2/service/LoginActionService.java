package com.webShop.member2.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

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
			request.setAttribute("err", false);
			
			session.setAttribute("id", id);
			session.setAttribute("admin", userInfo.getAdmin());
			
			nextPage = "/index.do";
		}
		else
		{
			request.setAttribute("err", true);
			nextPage = "/member/loginForm.do";
		}
		
		return nextPage;
	}
}
