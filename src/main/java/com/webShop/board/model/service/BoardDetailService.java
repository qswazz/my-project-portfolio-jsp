package com.webShop.board.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.board.model.dao.BoardDAO;
import com.webShop.board.vo.BoardVO;
import com.webShop.common.service.IService;

public class BoardDetailService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		int num = Integer.parseInt(request.getParameter("n"));
		
		String url = null;
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int readCount = dao.increaseReadCount(num);
		
		BoardVO boardDetail = dao.getBoard(num);

		if(boardDetail == null)
		{
			url = "/WEB-INF/view/board/boardError.jsp";

			request.setAttribute("msg", "Data is null.");			
		}
		else
		{
			url = "/WEB-INF/view/board/boardDetail.jsp";

			request.setAttribute("item", boardDetail);
		}
		
		return url;
	}

}
