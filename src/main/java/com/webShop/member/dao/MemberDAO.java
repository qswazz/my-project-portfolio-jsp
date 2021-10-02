package com.webShop.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.webShop.member.vo.MemberVO;

public class MemberDAO
{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;

	private static MemberDAO instance;
	
	public static MemberDAO getInstance()
	{
		if(instance == null)
		{
			instance = new MemberDAO();
		}
		
		return instance;
	}
	
	
	
	public MemberDAO()
	{
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public List<MemberVO> getMemberList() throws SQLException
	{
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try
		{
			String sql = "SELECT * FROM t_member";

			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO(id, pwd, name, email, phone, joinDate);
				
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
	
	
	
	public MemberVO getMember(String id) throws SQLException
	{
		MemberVO vo = null;
		
		try
		{
			String sql = "SELECT * FROM t_member WHERE ID = ?";
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				String id_ = rs.getString("id");
				String pwd_ = rs.getString("pwd");
				String name_ = rs.getString("name");
				String email_ = rs.getString("email");
				String phone_ = rs.getString("phone");
				Date joinDate_ = rs.getDate("joinDate");

//				vo.setId(id_);
//				vo.setPwd(pwd_);
//				vo.setName(name_);
//				vo.setEmail(email_);
//				vo.setPhone(phone_);
//				vo.setJoinDate(joinDate_);
				
				vo= new MemberVO(id_, pwd_, name_, email_, phone_, joinDate_);
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
		
		return vo;
	}
	
	
	
	public int addMember(MemberVO vo) throws SQLException
	{
		int result = -1;
		
		try
		{
			String sql = "INSERT INTO t_member(id, pwd, name, email, phone) VALUES (?, ?, ?, ?, ?)";
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			
			result = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			con.close();
		}
		
		return result;
	}
	
	
	
	public int updateMember(MemberVO vo) throws SQLException
	{
		int result = -1;
		
		try
		{
			String sql = "UPDATE t_member SET PWD = ?, NAME = ?, EMAIL = ?, PHONE = ? WHERE ID = ?";
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getId());
			
			result = pstmt.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			pstmt.close();
			con.close();
		}
		
		return result;
	}
	
	
	
	public boolean checkLogin(String id, String pwd) throws SQLException
	{
		boolean result = false;
		
		try
		{
			String sql = "SELECT * FROM t_member WHERE ID = ?";
			
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				if(pwd.equals(rs.getString("pwd")))
				{
					result = true;
				}
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
	
}
