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
import com.webShop.service.IService;

public class ListFormService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberVO> list = dao.getMemberList();
		
		request.setAttribute("list", list);

		String url = "list.jsp";
		
		return url;
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		
//		dispatcher.forward(request, response);
	}
}
