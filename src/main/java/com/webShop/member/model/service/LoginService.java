package com.webShop.member.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

public class LoginService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = null;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = dao.getMember(id);
		
		if(pwd.equals(vo.getPwd()))
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("id", id);
			session.setAttribute("admin", vo.getAdmin());
			
			url = "/index";
		}
		else
		{
			url = "/member?cmd=loginForm";
		}
		
		return url;
	}

}
