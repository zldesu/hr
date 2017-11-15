package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * 增加部门控制器
 * @author DLETC
 *
 */
@WebServlet("/addDeptServlet")
public class addDeptServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//响应输出
		PrintWriter pw = response.getWriter();
		//请求参数
		String deptName = request.getParameter("deptName");
		String deptLoc	 = request.getParameter("deptLoc");
		
		//封装为pojo对象
		Dept dept = new Dept(deptName,deptLoc);
		
		//调用服务对象功能
		DeptService service = new DeptService();
		
		try {
			service.addDept(dept);
			pw.println("成功");
			//重定向到查询
			response.sendRedirect("QueryDeptServlet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
