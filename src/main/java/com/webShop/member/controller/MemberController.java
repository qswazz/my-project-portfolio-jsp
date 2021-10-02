package com.webShop.member.controller;

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

import com.webShop.member.dao.MemberDAO;
import com.webShop.member.service.JoinActionService;
import com.webShop.member.service.LoginActionService;
import com.webShop.member.vo.MemberVO;
import com.webShop.service.IService;


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
		String nextPage = null;
		String command = request.getPathInfo();
		//System.out.println("��û command :" + command);
		
		
		// �α���
		if(command.equals("/loginForm.do"))
		{
			HttpSession session = request.getSession();

			if(session.getAttribute("id") == null)
			{
				nextPage = "/WEB-INF/view/member/login.jsp";
			}
			else
			{
				nextPage = "/WEB-INF/view/index.jsp";
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
		else if(command.equals("/loginAction.do"))
		{
			IService service = new LoginActionService();
			
			nextPage = service.execute(request, response);
			
			response.sendRedirect(nextPage);
		}
		
		// ȸ������
		else if(command.equals("/join.do"))
		{
			System.out.println("join ȣ��");
			nextPage = "/WEB-INF/view/member/join.jsp";

			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			
			dispatcher.forward(request, response);
		}
		else if(command.equals("/joinAction.do"))
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			IService service = new JoinActionService();

			nextPage = service.execute(request, response);
			
			//response.sendRedirect(nextPage);
			
			out.println("<script>alert('��� �Ϸ�Ǿ����ϴ� !'); ");
			out.println("location.href='" + nextPage + "';</script>");
			
			out.flush();
		}
		

		
		
		
//		
//		if(command.equals("/list.do"))
//		{
//			System.out.println("list.do ȣ��");
//			
//			IService service = new ListFormService();
//			
//			service.execute(request, response);
//		}
//		
//		else if(command.equals("/logout.do"))
//		{
//			session.invalidate();
//			
//			page = "/WEB-INF/view/index.jsp";
//		}
//		
//		
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
