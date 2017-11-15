package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.common.Page;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * 查询员工数据
 */
@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获得输出流
		PrintWriter pw = response.getWriter();
		//获得页码
		String pageNumStr = request.getParameter("pageNum");
		//获得每页多少条
		String pageSizeStr = request.getParameter("pageSize");
		int pageNum = 1;	
		int pageSize = 10;
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {
			
		}
		
		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {
			
		}
		
		
		EmpService service = new EmpService();
		try {
			Page page = new Page(service.getEmpCount(),pageSize,pageNum);
			List<Emp> list = service.queryEmpByPage(page);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("page", page);
			map.put("list", list);
			
			
			Gson gson = new GsonBuilder()  
					  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
					  .create(); 
			pw.write(gson.toJson(map));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
