package com.webShop.board.model.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webShop.board.model.dao.BoardDAO;
import com.webShop.board.vo.BoardVO;
import com.webShop.common.service.IService;

public class BoardUpdateService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/board?cmd=0";

		int num = Integer.parseInt(request.getParameter("n"));
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writeDate = request.getParameter("writeDate");
		String modifyDate = request.getParameter("modifyDate");
		
		BoardVO vo = new BoardVO(num, id, title, content, 0, writeDate, modifyDate);
		
		BoardDAO dao = BoardDAO.getInstance();

		int updateCount = dao.updateBoard(vo);
		
		List<BoardVO> list = dao.getBoardList();
		
		System.out.println("»ý¼º Çà °¹¼ö : " + updateCount);
		
		request.setAttribute("list", list);
		
		return url;
	}

}
