package com.webShop.member.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

public class DetailFormService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/WEB-INF/view/member/detail.jsp";
		
		String id = request.getParameter("id");

		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = dao.getMember(id);
		
		request.setAttribute("userInfo", vo);
		
		return url;
	}

}
