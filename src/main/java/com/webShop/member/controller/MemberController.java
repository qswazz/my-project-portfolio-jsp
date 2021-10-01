package com.webShop.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.member.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;


@WebServlet("/member/*")
public class MemberController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	
    public MemberController()
    {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("member doGet 호출");
		
		try
		{
			doHandle(request, response);
		}
		catch (ServletException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("member doGet 호출");
		
		try
		{
			doHandle(request, response);
		}
		catch (ServletException | IOException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String page = null;
		String command = request.getPathInfo();
		System.out.println("command :" + command);
		
		if(command.equals("/list.do"))
		{
			System.out.println("list.do 호출");
			
			MemberDAO dao = MemberDAO.getInstance();
			
			List<MemberVO> list = dao.getMemberList();
			
			request.setAttribute("list", list);
			
			page = "/WEB-INF/view/member/list.jsp";
		}
		
		// 로그인
		else if(command.equals("/login.do"))
		{
			System.out.println("login.do 호출");
			
			page = "/WEB-INF/view/member/login.jsp";
		}
		else if(command.equals("/loginCheck.do"))
		{
			System.out.println("loginCheck.do 호출");
			
			HttpSession session = request.getSession();

			if(session.isNew())
			{
				System.out.println("session 생성 : " + session);
			}
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			MemberDAO dao = MemberDAO.getInstance();
			
			MemberVO vo = dao.getMember(id);
			
			if(pwd.equals(vo.getPwd()))
			{
				session.setAttribute("vo", vo);
				
				List<MemberVO> list = dao.getMemberList();
				request.setAttribute("list", list);
				
				page = "/WEB-INF/view/member/list.jsp";
			}
			else
			{
				page = "/WEB-INF/view/member/login.jsp";
			}
		}
		
		// 회원가입
		else if(command.equals("/join.do"))
		{
			System.out.println("join.do 호출");
			
			page = "/WEB-INF/view/member/join.jsp";
		}
		else if(command.equals("/joinAction.do"))
		{
			System.out.println("joinAction.do 호출");
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			MemberDAO dao = MemberDAO.getInstance();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO vo = new MemberVO(id, pwd, name, email, phone, null);
			
			int result = dao.addMember(vo);
			System.out.println("추가된 행 갯수 : " + result);
			
			page = "/WEB-INF/view/member/login.jsp";			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		
		dispatcher.forward(request, response);
	}

}
