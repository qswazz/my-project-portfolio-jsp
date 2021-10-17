package com.webShop.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.common.controller.ServiceFactory;
import com.webShop.common.service.IService;


@WebServlet("/member")
public class MemberController extends HttpServlet
{
	private enum CommandType
	{
		REDIRECT
		,FORWARD
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String command = request.getParameter("cmd");
		CommandType type = null;
		
		switch (command)
		{
			case "loginForm":
				type = CommandType.FORWARD;
				break;
			case "login":
				type = CommandType.REDIRECT;
				break;
			case "logout":
				type = CommandType.REDIRECT;
				break;
			case "join":
				type = CommandType.REDIRECT;
				break;
			case "joinForm":
				type = CommandType.FORWARD;
				break;
			case "detail":
				type = CommandType.REDIRECT;
				break;
			case "detailForm":
				type = CommandType.FORWARD;
				break;
				
			case "0":
				command = "loginForm";
				type = CommandType.FORWARD;
				break;
			case "1":
				command = "login";
				type = CommandType.REDIRECT;
				break;
			case "2":
				command = "logout";
				type = CommandType.REDIRECT;
				break;
			case "3":
				command = "joinForm";
				type = CommandType.FORWARD;
				break;
			case "4":
				command = "join";
				type = CommandType.REDIRECT;
				break;
			case "5":
				command = "listForm";
				type = CommandType.FORWARD;
				break;
			case "6":
				command = "updateUserType";
				type = CommandType.REDIRECT;
				break;
			default:
				break;
		}
		
		System.out.println("사용자 요청 Command : " + command);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();

		// 요청에 따른 service를 호출
		IService service = serviceFactory.getAction(command);
		
		if(service != null)
		{
			try
			{
				String nextPage = service.execute(request, response);
				
				if(type == CommandType.REDIRECT)
				{
					response.sendRedirect(nextPage);
				}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
					
					dispatcher.forward(request, response);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}
	
	
}
