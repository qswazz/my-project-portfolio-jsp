package com.webShop.board.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.board.model.dao.BoardDAO;
import com.webShop.board.vo.BoardVO;
import com.webShop.common.service.IService;

public class BoardListService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/WEB-INF/view/board/boardList.jsp";
		
		BoardDAO dao = BoardDAO.getInstance();
		
		List<BoardVO> list = dao.getBoardList();
		
		request.setAttribute("list", list);
		
		return url;
	}

}
