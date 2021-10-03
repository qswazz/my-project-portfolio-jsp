package com.webShop.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

import com.webShop.board.vo.BoardVO;

public class BoardDAO
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;
	
	private static BoardDAO instance;
	
	public static BoardDAO getInstance()
	{
		if(instance == null)
		{
			instance = new BoardDAO();
		}
		
		return instance;
	}
	
	
	public BoardDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<BoardVO> getBoardList() throws SQLException
	{
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try
		{
			String sql = "SELECT * FROM t_board";
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int num_ = rs.getInt("num");
				String id_ = rs.getString("id");
				String title_ = rs.getString("title");
				String content_ = rs.getString("content");
				int readCount_ = rs.getInt("readCount");
				String writeDate_ = rs.getString("writeDate");
				String modifyDate_ = rs.getString("modifyDate");

				BoardVO vo = new BoardVO(num_, id_, title_, content_, readCount_, writeDate_, modifyDate_);
				
				list.add(vo);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		
		return list;
	}
	
	
	public BoardVO getBoard(int num) throws SQLException
	{
		BoardVO result = null;
		
		try
		{
			String sql = "SELECT * FROM t_board WHERE NUM = ?";

			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  num);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int num_ = rs.getInt("num");
				String id_ = rs.getString("id");
				String title_ = rs.getString("title");
				String content_ = rs.getString("content");
				int readCount_ = rs.getInt("readCount");
				String writeDate_ = rs.getString("writeDate");
				String modifyDate_ = rs.getString("modifyDate");
				
				result = new BoardVO(num_, id_, title_, content_, readCount_, writeDate_, modifyDate_);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			pstmt.close();
			con.close();
		}
		
		return result;
	}
	
	
	public int insertBoard(BoardVO vo) throws SQLException
	{
		int result = -1;
		
		try
		{
			String sql = "INSERT INTO t_board(NUM, ID, TITLE, CONTENT, READCOUNT, WRITEDATE, MODIFYDATE) VALUES (BOARD_SEQ.nextval, ?, ?, ?, 0, ?, ?)";

			String id_ = vo.getId();
			String title_ = vo.getTitle();
			String content_ = vo.getContent();
			String writeDate_ = vo.getWriteDate();
			String modifyDate_ = vo.getModifyDate();
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id_);
			pstmt.setString(2, title_);
			pstmt.setString(3, content_);
			pstmt.setString(4, writeDate_);
			pstmt.setString(5, modifyDate_);
			
			result = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			con.close();
		}
		
		return result;
	}
	
}
