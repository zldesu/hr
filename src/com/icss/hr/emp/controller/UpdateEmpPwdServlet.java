package com.icss.hr.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * �޸����������
 */
@WebServlet("/UpdateEmpPwdServlet")
public class UpdateEmpPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ò���
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		
		//��װpojo
		Emp emp = new Emp();
		emp.setEmpLoginName(empLoginName);
		emp.setEmpPwd(empPwd);
		
		
		EmpService service = new EmpService();
		try {
			service.updatePwd(emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
