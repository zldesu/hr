package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.common.Page;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.pojo.Emp;

/**
 * 员工的业务
 * @author DLETC
 *
 */
public class EmpService {
	private EmpDao ed = new EmpDao();
	
	/**
	 * 传入用户名密码，验证登录
	 * @param empLoginName
	 * @param empPwd
	 * @return 返回1代表不存在，返回2代表密码错误，返回3代表登录成功
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		Emp emp = ed.queryByLoginName(empLoginName);
		
		if(emp == null) {
			return 1;
		}else if (!empPwd.equals(emp.getEmpPwd())) {
			return 2;
		}else {
			return 3;
		}
	}
	
	//新增
	public void addEmp(Emp emp) throws SQLException {
		ed.insert(emp);
	} 
	
	//修改
	public void update(Emp emp) throws SQLException  {
		ed.update(emp);
	}
	//修改密码
	public void updatePwd(Emp emp) throws SQLException  {
		ed.updatePwd(emp);
	}
	
	//删除
	public void delete(int empId) throws SQLException {
		ed.delete(empId);
	}
	
	//查询id
	public Emp queryById(int empId) throws SQLException {
		return ed.queryById(empId);
	}
	
	//查询所有
	public List<Emp> queryEmpByPage(Page page) throws SQLException {
		return ed.queryByPage(page);
	}
	
	public Emp queryEmpByLoginName(String empLoginName) throws SQLException {
		return ed.queryByLoginName(empLoginName);
	}
	
	//获得总记录数
	public int getEmpCount() throws SQLException {
		return ed.getCount();
	}
	
	/**
	 * 修改用户头像
	 * @throws SQLException 
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		ed.updatePic(empLoginName, empPic);
	}
}
