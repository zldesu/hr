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
 * ��֤��¼���ݷ��ʽӿ�
 * �û��������ڣ���Ӧ1
 * ���������Ӧ2
 * ��½�ɹ�����Ӧ3
 * @author DLETC
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//��������
		PrintWriter pw = response.getWriter();
		//��ǰ�˻�ȡ����
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		//����servlet����
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
