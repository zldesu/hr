package com.icss.hr.dept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * 查询部门控制器
 */
@WebServlet("/QueryDeptServlet")
public class QueryDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService service = new DeptService();
		try {
			List<Dept> list = service.queryDept();
			//核心思想：请求转发使用同一个request;
			request.setAttribute("list", list);
			//请求转发到jsp
			/*RequestDispatcher rd = request.getRequestDispatcher("/QueryDept.jsp");
			rd.forward(request, response);*/
			request.getRequestDispatcher("/QueryDept.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//手动转发到错误页
			request.getRequestDispatcher("/error.html").forward(request, response);
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
