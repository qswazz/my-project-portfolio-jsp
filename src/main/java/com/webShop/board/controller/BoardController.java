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
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String command = null;
		
		switch (request.getParameter("cmd"))
		{
			case "0":
				command = "boardList";
				break;
			case "1":
				command = "boardDetail";
				break;
			case "2":
				command = "boardWriteForm";
				break;
			case "3":
				command = "boardWrite";
				break;
			default:
				command = "boardList";
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
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
				
				dispatcher.forward(request, response);
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
