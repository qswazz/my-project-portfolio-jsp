package com.webShop.board.controller;

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

@WebServlet("/board")
public class BoardController extends HttpServlet
{
	private enum CommandType
	{
		REDIRECT
		,FORWARD
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String command = null;
		CommandType type = null;
		
		switch (request.getParameter("cmd"))
		{
			case "0":
				command = "boardList";
				type = CommandType.FORWARD;
				break;
			case "1":
				command = "boardDetail";
				type = CommandType.FORWARD;
				break;
			case "2":
				command = "boardWriteForm";
				type = CommandType.FORWARD;
				break;
			case "3":
				command = "boardWrite";
				type = CommandType.REDIRECT;
				break;
			case "4":
				command = "boardUpdateForm";
				type = CommandType.FORWARD;
				break;
			case "5":
				command = "boardUpdate";
				type = CommandType.REDIRECT;
				break;
			case "6":
				command = "boardDelete";
				type = CommandType.REDIRECT;
				break;
			default:
				command = "boardList";
				type = CommandType.FORWARD;
				break;
		}
		
		System.out.println("����� ��û Command : " + command);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();

		// ��û�� ���� service�� ȣ��
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
