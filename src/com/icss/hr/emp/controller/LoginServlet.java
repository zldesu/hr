package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.emp.service.EmpService;
/**
 * 验证登录数据访问接口
 * 用户名不存在，响应1
 * 密码错误，响应2
 * 登陆成功，响应3
 * @author DLETC
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得输出流
		PrintWriter pw = response.getWriter();
		//从前端获取参数
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		//调用servlet方法
		EmpService service = new EmpService();
		try {
			int loginFlag = service.checkLogin(empLoginName, empPwd);
			
			if(loginFlag == 3) {
				HttpSession session = request.getSession();
				session.setAttribute("empLoginName", empLoginName);
			}
			pw.print(loginFlag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
