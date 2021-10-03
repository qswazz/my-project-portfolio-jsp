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

public class BoardWriteService implements IService
{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String url = "/board?cmd=0";
		
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writeDate = request.getParameter("writeDate");
		String modifyDate = request.getParameter("modifyDate");
		
//		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
//		Date writeDate = null;
//		Date modifyDate = null;
//		
//		try
//		{
//			writeDate = simpleDate.parse(request.getParameter("writeDate"));
//			modifyDate = simpleDate.parse(request.getParameter("modifyDate"));
//		}
//		catch (ParseException e1)
//		{
//			e1.printStackTrace();
//		}
		
		BoardVO vo = new BoardVO(0, id, title, content, 0, writeDate, modifyDate);
		
		BoardDAO dao = BoardDAO.getInstance();

		int addCount = dao.insertBoard(vo);
		List<BoardVO> list = dao.getBoardList();
		
		System.out.println("»ý¼º Çà °¹¼ö : " + addCount);
		
		request.setAttribute("list", list);
		
		return url;
	}

}
