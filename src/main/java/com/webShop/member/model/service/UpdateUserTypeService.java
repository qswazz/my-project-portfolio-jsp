package com.webShop.member.model.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.common.service.IService;
import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

public class UpdateUserTypeService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/member?cmd=5";
		
		String id = request.getParameter("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO vo = dao.getMember(id);
		
		int result = dao.updateUserType(vo);
		
		System.out.println("변경된 행 갯수 : " + result);
		
		return url;
	}

}
