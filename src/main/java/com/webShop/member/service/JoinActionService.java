package com.webShop.member.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.member.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;
import com.webShop.service.IService2;

public class JoinActionService implements IService2
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nextPage = null;

		MemberDAO dao = MemberDAO.getInstance();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO(id, pwd, name, email, phone, null, null);
		
		int result = dao.addMember(vo);
		
		nextPage = "/member/loginForm.do";
		//nextPage = "/member/loginForm.do?add=" + result;
		
		return nextPage;
	}
}

