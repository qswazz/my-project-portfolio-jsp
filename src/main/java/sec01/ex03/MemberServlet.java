package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webShop.member.model.dao.MemberDAO;
import com.webShop.member.vo.MemberVO;

@WebServlet("/regMember")
public class MemberServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			doHandle(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			doHandle(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		PrintWriter out=response.getWriter();
		String command=request.getParameter("command");
		
		if(command!= null && command.equals("addMember"))
		{
			String _id=request.getParameter("id");
			String _pwd=request.getParameter("pwd");
			String _name=request.getParameter("name");
			String _email=request.getParameter("email");
			 
			MemberVO vo=new MemberVO();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
		    dao.insertMember(vo);
	    }
		
		List list=dao.getMemberList();
	    out.print("<html><body>");
	    out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
	    out.print("<td>??????</td><td>????????</td><td>????</td><td>??????</td><td>??????</td><td >????</td></tr>");
	    
	    for (int i=0; i<list.size();i++)
	    {
	    	MemberVO memberVO=(MemberVO) list.get(i);
	 		String id=memberVO.getId();
	 		String pwd = memberVO.getPwd();
	 		String name = memberVO.getName();
	 		String email =memberVO.getEmail();
	 		Date joinDate = memberVO.getJoinDate();
	 		out.print("<tr><td>"+id+"</td><td>"
	 			                +pwd+"</td><td>"
	 			                +name+"</td><td>"
	 			                +email+"</td><td>"
	 			                +joinDate+"</td><td>"
	 		                    +"<a href='/pro07/member3?command=delMember&id="+id+"'>???? </a></td></tr>");

	    }
	 	out.print("</table></body></html>");
	    out.print("<a href='/pro07/memberForm.html'>?? ???? ????????</a");
	}
	
}
