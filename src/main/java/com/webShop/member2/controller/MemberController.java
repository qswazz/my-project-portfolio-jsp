package com.webShop.member2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.member.service.JoinActionService;
import com.webShop.member.service.ListFormService;
import com.webShop.member.service.LoginActionService;
import com.webShop.service.IService2;


@WebServlet("/member2/*")
public class MemberController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	
	private enum CommandType
	{
		REDIRECT
		, FORWARD
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		CommandType commandType = null;
		String command = request.getPathInfo();
		String nextPage = null;
		
		
		// 로그인
		if(command.equals("/loginForm.do"))
		{
			HttpSession session = request.getSession();

			if(session.getAttribute("id") == null)
			{
				commandType = CommandType.FORWARD;
				nextPage = "/WEB-INF/view/member/login.jsp";
			}
			else
			{
				commandType = CommandType.REDIRECT;
				nextPage = "/index.do";
			}
		}
		else if(command.equals("/loginAction.do"))
		{
			commandType = CommandType.REDIRECT;
			
			IService2 service = new LoginActionService();

			nextPage = service.execute(request, response);
			
			boolean isErr = (boolean) request.getAttribute("err");
			
			if(isErr == true)
			{
				out.println("<script>alert('정보가 존재하지 않습니다.'); ");
				out.println("location.href='" + nextPage + "';</script>");
				out.flush();
				
				return;
			}
		}
		else if(command.equals("/logout.do"))
		{
			commandType = CommandType.REDIRECT;
			
			HttpSession session = request.getSession();

			System.out.println("path : " + request.getRequestURI());
			session.invalidate();
			
			nextPage = "/index.do";
		}
		
		
		// 회원가입
		else if(command.equals("/joinForm.do"))
		{
			HttpSession session = request.getSession();
			
			if(session.getAttribute("id") == null)
			{
				commandType = CommandType.FORWARD;
				nextPage = "/WEB-INF/view/member/join.jsp";				
			}
			else
			{
				commandType = CommandType.REDIRECT;
				nextPage = "/index.do";
			}
		}
		else if(command.equals("/joinAction.do"))
		{
			commandType = CommandType.REDIRECT;
			//commandType = "redirect";
			
			IService2 service = new JoinActionService();

			nextPage = service.execute(request, response);
			
			out.println("<script>alert('등록 완료되었습니다.'); ");
			out.println("location.href='" + nextPage + "';</script>");
			out.flush();
			
			return;
		}

		
		// 리스트
		else if(command.equals("/listForm.do"))
		{
			commandType = CommandType.FORWARD;
			
			IService2 service = new ListFormService();
			
			nextPage = service.execute(request, response);
		}
				
		
		
		
		
		

		// 페이지 이동
		if(commandType.equals(CommandType.REDIRECT))
		{
			response.sendRedirect(nextPage);
		}
		else if(commandType.equals(CommandType.FORWARD))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
		
		
		
//		// 회원정보 수정
//		else if(command.equals("/detail.do"))
//		{
//			System.out.println("detail.do 호출");
//			
//			MemberVO vo = (MemberVO) session.getAttribute("vo");
//			
//			request.setAttribute("vo", vo);
//			
//			page = "/WEB-INF/view/member/detail.jsp";
//		}
//		else if(command.equals("/detailAction.do"))
//		{
//			request.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=UTF-8");
//			
//			String id = request.getParameter("id");
//			String pwd = request.getParameter("pwd");
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			String phone = request.getParameter("phone");
//			
//			MemberVO vo = new MemberVO(id, pwd, name, email, phone, null);
//			
//			MemberDAO dao = MemberDAO.getInstance();
//			
//			int result = dao.updateMember(vo);
//			
//			System.out.println("수정된 항목 갯수 : " + result);
//			
//			page = "/WEB-INF/view/member/login.jsp";
//		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//		
//		dispatcher.forward(request, response);
	}

}
