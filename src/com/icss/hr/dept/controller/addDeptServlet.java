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
 * ���Ӳ��ſ�����
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
		//��Ӧ���
		PrintWriter pw = response.getWriter();
		//�������
		String deptName = request.getParameter("deptName");
		String deptLoc	 = request.getParameter("deptLoc");
		
		//��װΪpojo����
		Dept dept = new Dept(deptName,deptLoc);
		
		//���÷��������
		DeptService service = new DeptService();
		
		try {
			service.addDept(dept);
			pw.println("�ɹ�");
			//�ض��򵽲�ѯ
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
