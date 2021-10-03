package com.webShop.member.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.member.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;
import com.webShop.service.IService2;

public class ListFormService implements IService2
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberVO> list = dao.getMemberList();
		
		request.setAttribute("list", list);

		String nextPage = "/WEB-INF/view/member/list.jsp";
		
		return nextPage;
	}
}
