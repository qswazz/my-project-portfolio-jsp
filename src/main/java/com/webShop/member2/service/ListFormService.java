package com.webShop.member2.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

public class ListFormService implements IService
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
