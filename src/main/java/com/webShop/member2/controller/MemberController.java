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
		
		
		// �α���
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
				out.println("<script>alert('������ �������� �ʽ��ϴ�.'); ");
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
		
		
		// ȸ������
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
			
			out.println("<script>alert('��� �Ϸ�Ǿ����ϴ�.'); ");
			out.println("location.href='" + nextPage + "';</script>");
			out.flush();
			
			return;
		}

		
		// ����Ʈ
		else if(command.equals("/listForm.do"))
		{
			commandType = CommandType.FORWARD;
			
			IService2 service = new ListFormService();
			
			nextPage = service.execute(request, response);
		}
				
		
		
		
		
		

		// ������ �̵�
		if(commandType.equals(CommandType.REDIRECT))
		{
			response.sendRedirect(nextPage);
		}
		else if(commandType.equals(CommandType.FORWARD))
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
		
		
		
//		// ȸ������ ����
//		else if(command.equals("/detail.do"))
//		{
//			System.out.println("detail.do ȣ��");
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
//			System.out.println("������ �׸� ���� : " + result);
//			
//			page = "/WEB-INF/view/member/login.jsp";
//		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//		
//		dispatcher.forward(request, response);
	}

}
