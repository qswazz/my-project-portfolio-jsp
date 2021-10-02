package sec01.ex03;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")
public class EncoderFilter implements Filter
{
	private ServletContext context;
	
	
    public EncoderFilter()
    {

    }

    
	public void destroy()
	{
		System.out.println("destroy ȣ��");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		System.out.println("doFilter ȣ��");
		
		request.setCharacterEncoding("UTF-8");
		
		String context = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathInfo);
		
		String msg = "Context���� : " + context
				+ "\nURI���� : " + pathInfo
				+ "\n������� : " + realPath;
		
		System.out.println(msg);
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException
	{
		System.out.println("Encoder ����");
		context = fConfig.getServletContext();
	}

}
