		package com.icss.hr.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 公共过滤器
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		
		//转换类型
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1; 
		
		//设置允许其他域访问当前项目
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//输出请求url
		String uri = request.getRequestURI().toString();
		System.out.println(uri);
		
		//web应用的名称
		String app = request.getContextPath();
		System.out.println("app" + app);
		//判断用户登录拦截
		if(!uri.equals(app + "/") 
				&& !uri.equals(app + "/login.html")
				&& !uri.equals(app + "/loginout.jsp")
				&& !uri.equals(app + "/LoginServlet") 
				&& !uri.startsWith(app + "/css")
				&& !uri.startsWith(app + "/js")
				&& !uri.startsWith(app + "/images")) {
			
			HttpSession session = request.getSession();
			String empLoginName = (String) session.getAttribute("empLoginName");
			
			
			if(empLoginName == null) {
				
				//判断当前请求是否是ajax请求；
				String ajaxHeader = request.getHeader("x-requested-with");
				
				//如果是ajax请求在响应的报头中设置一个特殊的标识，以便于前端做判断
				if(ajaxHeader != null && ajaxHeader.equalsIgnoreCase("XMLHttpRequest")) {
					response.setHeader("sessionStatus", "timeout");
				} else {
					response.sendRedirect("loginout.jsp");
				}	
				
				//统一关闭connection
				DBUtil.close();
			//	response.sendRedirect(app + "/loginout.jsp");
				return;
			}
		}
		
		//继续往下执行	
		chain.doFilter(request, response);
		//统一关闭connection
		DBUtil.close();
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
