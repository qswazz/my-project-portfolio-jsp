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

public class DetailService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = "2";

		String url = "/member?cmd=detailForm&id=" + id;
		
		MemberDAO dao = MemberDAO.getInstance();

		MemberVO vo = new MemberVO(id, pwd, name, email, phone, null, admin);
		
		int result = dao.updateMember(vo);

		System.out.println("변경된 행 갯수 : " + result);
		
		return url;
	}

}
