package com.webShop.common.controller;

import com.webShop.board.model.service.BoardDeleteService;
import com.webShop.board.model.service.BoardDetailService;
import com.webShop.board.model.service.BoardListService;
import com.webShop.board.model.service.BoardUpdateFormService;
import com.webShop.board.model.service.BoardUpdateService;
import com.webShop.board.model.service.BoardWriteFormService;
import com.webShop.board.model.service.BoardWriteService;
import com.webShop.common.service.IService;
import com.webShop.member.model.service.JoinFormService;
import com.webShop.member.model.service.JoinService;
import com.webShop.member.model.service.ListFormService;
import com.webShop.member.model.service.LoginFormService;
import com.webShop.member.model.service.LoginService;
import com.webShop.member.model.service.LogoutService;

public class ServiceFactory
{
	private static ServiceFactory instance;

	public static ServiceFactory getInstance()
	{
		if(instance == null)
		{
			instance = new ServiceFactory();
		}
		
		return instance;
	}
	

	private ServiceFactory()
	{
		
	}

	
	public IService getAction(String command)
	{
		IService action = null;
		
		// °Ô½Ã¹°
		if(command.equals("boardList"))
		{
			action = new BoardListService();
		}
		else if(command.equals("boardDetail"))
		{
			action = new BoardDetailService();
		}
		else if(command.equals("boardWriteForm"))
		{
			action = new BoardWriteFormService();
		}
		else if(command.equals("boardWrite"))
		{
			action = new BoardWriteService();
		}
		else if(command.equals("boardUpdateForm"))
		{
			action = new BoardUpdateFormService();
		}
		else if(command.equals("boardUpdate"))
		{
			action = new BoardUpdateService();
		}
		else if(command.equals("boardDelete"))
		{
			action = new BoardDeleteService();
		}
		
		
		// ¸â¹ö
		if(command.equals("loginForm"))
		{
			action = new LoginFormService();
		}
		else if(command.equals("login"))
		{
			action = new LoginService();
		}
		else if(command.equals("logout"))
		{
			action = new LogoutService();
		}
		else if(command.equals("joinForm"))
		{
			action = new JoinFormService();
		}
		else if(command.equals("join"))
		{
			action = new JoinService();
		}
		else if(command.equals("listForm"))
		{
			action = new ListFormService();
		}
		
		
		return action;
	}
	
}
